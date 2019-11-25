package ExBankServer;

import java.util.concurrent.locks.ReentrantLock;

class Account {
    private float balance;
    private boolean closed;
    private ReentrantLock lockAcc;

    public Account(float balance) {
        this.balance = balance;
        this.closed = false;
        this.lockAcc = new ReentrantLock();
    }

    public void close(){
        this.balance = 0;
        this.closed = true;
    }

    public boolean isClosed(){
        return closed;
    }

    public float getBalance() {
        return balance;
    }

    public void lock(){
        this.lockAcc.lock();
    }

    public void unlock(){
        this.lockAcc.unlock();
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void deposit(float value) {
        this.balance += value;
    }

    public void credit(float value) {
        this.balance -= value;
    }
}
