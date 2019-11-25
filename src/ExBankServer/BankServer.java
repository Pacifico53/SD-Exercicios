package ExBankServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BankServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Bank bank = new Bank();

        while (true) {
            Socket clSock;

            clSock = serverSocket.accept();

            BankWorker bankWorker = new BankWorker(bank, clSock);
            Thread thread = new Thread(bankWorker);

            thread.start();
        }

    }
}
