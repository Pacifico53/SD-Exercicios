package Ex4_BancoLocks;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

class Bank {
    private ArrayList<Account> accounts;
    private ReentrantLock lockBank;

    Bank() {
        this.accounts = new ArrayList<>();
        this.lockBank = new ReentrantLock();
    }

    public int createAccount(float initialBalance){
        //TODO usar set para fazer replace de contas ja fechadas
        lockBank.lock();

        Account a = new Account(initialBalance);
        accounts.add(a);

        lockBank.unlock();
        return accounts.indexOf(a);
    }

    public float closeAccount(int id) throws InvalidAccount {
        lockBank.lock();

        if (accounts.size() <= id || accounts.get(id).isClosed()){
            throw new InvalidAccount();
        }

        Account a = accounts.get(id);
        float r = a.getBalance();
        a.close();

        lockBank.unlock();
        return r;
    }

    public void transfer(int from, int to, float amount) throws InvalidAccount, NotEnoughFunds {
        lockBank.lock();

        Account a0 = accounts.get(from);
        Account a1 = accounts.get(to);

        if (a0.isClosed() || a1.isClosed()){
            throw new InvalidAccount();
        }

        if (a0.getBalance() < amount){
            throw new NotEnoughFunds();
        }

        a0.credit(amount);
        a1.deposit(amount);

        lockBank.unlock();
    }

    public float totalBalance(int[] accounts) {
        float t = 0;
        for(int i : accounts){
            t += this.accounts.get(i).getBalance();
        }
        return t;
    }

    public void deposit(int id, float value){
        lockBank.lock();

        Account a = accounts.get(id);
        a.deposit(value);

        lockBank.unlock();
    }

    public float check(int id){
        lockBank.lock();

        Account a = accounts.get(id);
        float r = a.getBalance();

        lockBank.unlock();

        return r;
    }

}
