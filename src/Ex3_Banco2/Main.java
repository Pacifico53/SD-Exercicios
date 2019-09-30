package Ex3_Banco2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int nContas = 100;

        Banco bank = new Banco(nContas);

        ArrayList<Thread> threads = new ArrayList<>();

        Thread t1 = new Thread(new Cliente1(bank, bank.getContas()[0]));
        threads.add(t1);

        Thread t2 = new Thread(new Cliente2(bank, bank.getContas()[1]));
        threads.add(t2);

        for (Thread th : threads) {
            th.start();
        }
    }
}
