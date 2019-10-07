package Ex4_BancoLocks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ArrayList<Thread> threads = new ArrayList<>();

        int id1 = bank.createAccount(0);
        Thread t1 = new Thread(new Cliente1(id1));
        threads.add(t1);

        for (Thread th : threads) {
            th.start();
        }
    }
}
