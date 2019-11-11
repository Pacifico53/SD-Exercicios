package ExRWLock;

import java.awt.desktop.SystemEventListener;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RWLock {
    private ReentrantLock lock;
    private Condition readerCondition;
    private Condition writerCondition;
    private int readers;
    private int writers;

    public RWLock() {
        lock = new ReentrantLock();
        readerCondition = this.lock.newCondition();
        writerCondition = this.lock.newCondition();
        readers = 0;
        writers = 0;
    }

    void readLock() throws InterruptedException {
        lock.lock();

        while(writers > 0){
            readerCondition.await();
        }
        readers++;

        lock.unlock();
    }

    void readUnlock(){
        readers--;
        System.out.println("Readers = " + readers);
        if(readers > 0){
            writerCondition.signal();
        }
    }

    void writeLock() throws InterruptedException {
        lock.lock();

        while(readers > 0 || writers > 0){
            writerCondition.await();
        }
        writers++;

        lock.unlock();
    }

    void writeUnlock(){
        writers--;
        if(writers>0) {
            readerCondition.signal();
        }
    }
}
