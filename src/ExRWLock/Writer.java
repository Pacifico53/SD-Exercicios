package ExRWLock;

import static java.lang.Thread.sleep;

public class Writer implements Runnable{
    private RWLock rwlock;

    public Writer(RWLock rwlock) {
        this.rwlock = rwlock;
    }

    public void run() {
        try {
            rwlock.writeLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //SLEEP 1 SEC
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        rwlock.writeUnlock();
    }
}
