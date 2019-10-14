package Ex4_BancoLocks;

class Account {
    private float balance;
    private boolean closed;

    public Account(float balance) {
        this.balance = balance;
        this.closed = false;
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
