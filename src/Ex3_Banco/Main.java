package Ex3_Banco;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        int nThreads = 2;
        int nContas = 100;

        Banco bank = new Banco(nContas);

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i<nThreads; i++){
            Thread t = new Thread(new Service(bank, i));
            threads.add(t);
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}
