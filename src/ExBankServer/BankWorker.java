package ExBankServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BankWorker implements Runnable {
    private Socket clSock;
    private Bank bank;
    private int id;

    public BankWorker(Bank bank, Socket clSock) {
        this.bank = bank;
        this.clSock = clSock;
        this.id = -1;
    }

    public String checkMessage(String msg) {
        String response = "Invalid command\n";
        String[] parsedmsg = msg.toLowerCase().split(" ");

        if (parsedmsg[0].equals("help")){
            response = "List of commands:\n"
                    +  "'create [initialMoney]'\n"
                    +  "'login [id]'\n"
                    +  "'check'\n"
                    +  "'deposit [amount]'\n"
                    +  "'credit [amount]'\n"
                    +  "'transfer [destination_id] [amount]'\n"
                    +  "'close'\n"
                    +  "'logout'\n"
                    +  "'exit'\n";
        }

        if (parsedmsg[0].equals("create") && parsedmsg.length > 1){
            int id = bank.createAccount(Float.parseFloat(parsedmsg[1]));
            response = "Account created. ID: " + id + "\nType \"login [ID]\" to login.\n";
        }

        if (parsedmsg[0].equals("login") && parsedmsg.length == 2){
            try {
                id = Integer.parseInt(parsedmsg[1]);
                bank.check(id);
                response = "Logged in to: " + parsedmsg[1] + ".\n";
            } catch (InvalidAccount invalidAccount) {
                response = invalidAccount.getErrorMsg(id);
                id = -1;
            }
        }

        if (parsedmsg[0].equals("check") && parsedmsg.length == 2){
            try {
                response = "Available money for ID: " + parsedmsg[1] +" is " + bank.check(Integer.parseInt(parsedmsg[1])) + ".\n";
            } catch (InvalidAccount invalidAccount) {
                response = invalidAccount.getErrorMsg(id);
            }
        }

        if (parsedmsg[0].equals("logout") && parsedmsg.length == 2){
            id = -1;
            response = "Successfully logged out. Please log in into another account or create new account.\n";
        }

        if (parsedmsg[0].equals("deposit") && parsedmsg.length == 3){
            float amount = Float.parseFloat(parsedmsg[1]);
            try {
                bank.deposit(Integer.parseInt(parsedmsg[2]), amount);
                response = "Deposited " + amount + " into your account. (ID = "+id+").\n";
            } catch (InvalidAccount invalidAccount) {
                response = invalidAccount.getErrorMsg(id);
            }
        }

        if (parsedmsg[0].equals("credit") && parsedmsg.length == 3){
            float amount = Float.parseFloat(parsedmsg[1]);
            try {
                bank.credit(Integer.parseInt(parsedmsg[2]), amount);
                response = "Removed " + amount + " from your account. (ID = "+id+").\n";
            } catch (InvalidAccount invalidAccount) {
                response = invalidAccount.getErrorMsg(id);
            } catch (NotEnoughFunds notEnoughFunds) {
                response = notEnoughFunds.getErrorMsg(id);
            }
        }

        if (parsedmsg[0].equals("transfer") && parsedmsg.length == 4){
            float amount = Float.parseFloat(parsedmsg[2]);
            int dest = Integer.parseInt(parsedmsg[1]);
            try {
                bank.transfer(id, dest, amount);
                response = "Transferred " + amount + " from your account (ID = "+id+") to account ID = "+dest+".\n";
            } catch (InvalidAccount error) {
                response = error.getErrorMsg(id);
            } catch (NotEnoughFunds error) {
                response = error.getErrorMsg(id);
            }
        }

        if (parsedmsg[0].equals("close") && parsedmsg.length == 2){
            try {
                bank.closeAccount(id);
                id = -1;
                response = "Closed account: " + parsedmsg[1] + ".\n";
            } catch (InvalidAccount invalidAccount) {
                response = invalidAccount.getErrorMsg(id);
            }
        }

        return response;
    }

    public void run() {
        String s;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
            PrintWriter out = new PrintWriter(clSock.getOutputStream());

            while ((s = in.readLine()) != null) {
                if (id != -1){
                    s = s+" "+id;
                }
                System.out.println("Got a message (\"" + s + "\").");

                if (s.contains("exit")){
                    break;
                }

                String response = checkMessage(s);
                out.print(response);
                out.flush();
            }

            clSock.shutdownOutput();
            clSock.shutdownInput();
            clSock.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
