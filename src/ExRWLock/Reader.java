package ExRWLock;

import static java.lang.Thread.sleep;

public class Reader implements Runnable {
    private RWLock rwLock;

    public Reader(RWLock rwlock) {
        this.rwLock = rwlock;
    }

    public void run() {
        try {
            rwLock.readLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //SLEEP 1 SEC
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        rwLock.readUnlock();
    }
}
