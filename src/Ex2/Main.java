package Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String strN, strI;
        int intN, intI;
        ArrayList<Thread> threads;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("N (num threads) = ?");
        strN = in.readLine();
        intN = Integer.parseInt(strN);

        System.out.println("I (inc max) = ?");
        strI = in.readLine();
        intI = Integer.parseInt(strI);

        System.out.println("Iniciando com N = " + strN + " threads e I = " + strI);

        threads = new ArrayList<>(intN);
        Counter c = new Counter(0);

        for(int i = 0; i < intN; i++){
            Thread t = new Thread(new Incrementer(c, intI));
            threads.add(t);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Done, num total = "+c.getN());
    }
}
