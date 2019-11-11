package ExRWLock;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RWLock rwlock = new RWLock();

        ArrayList<Thread> readers= new ArrayList<>(15);
        ArrayList<Thread> writers = new ArrayList<>(15);

        for(int i = 0; i<15; i++){
            readers.add(new Thread(new Reader(rwlock)));
            writers.add(new Thread(new Writer(rwlock)));
        }

        for (int i = 0; i<15; i++){
            readers.get(i).start();
            writers.get(i).start();
        }
    }
}
