package Ex4_BancoLocks;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ArrayList<Thread> threads = new ArrayList<>();

        Thread t1 = new Thread(new Cliente1(bank, 1));
        threads.add(t1);

        Thread t2 = new Thread(new Cliente2(bank, 1));
        threads.add(t2);

        for (Thread th : threads) {
            th.start();
        }
    }
}
