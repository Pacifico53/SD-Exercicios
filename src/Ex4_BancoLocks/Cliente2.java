package Ex4_BancoLocks;

import static java.lang.Thread.sleep;

public class Cliente2 implements Runnable{
    private int id;
    private Bank bank;

    public Cliente2(Bank bank) {
        this.id = 0;
        this.bank = bank;
    }

    public void run() {

        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int array[] = {0,1,2,3,4};

        try {
            bank.transfer(10, 0, 50);
        } catch (InvalidAccount | NotEnoughFunds invalidAccount) {
            invalidAccount.printStackTrace();
        }

        try {
            float total = bank.totalBalance(array);
            System.out.println("Total = " + total);
        } catch (InvalidAccount invalidAccount) {
            invalidAccount.printStackTrace();
        }
    }
}
