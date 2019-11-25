package ExBankServer;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private ArrayList<Account> accounts;
    private ReentrantLock lockBank;

    Bank() {
        this.accounts = new ArrayList<>();
        this.lockBank = new ReentrantLock();
    }

    public int createAccount(float initialBalance){
        lockBank.lock();

        boolean f = false;
        Account a = new Account(initialBalance);

        //Se houver uma account fechada, esta nova account vai substitui la
        for (int i = 0; i<this.accounts.size() && !f; i++){
            if (this.accounts.get(i).isClosed()){
                accounts.set(i, a);
                f = true;
            }
        }

        if (!f){
            accounts.add(a);
        }

        lockBank.unlock();
        return accounts.indexOf(a);
    }

    public float closeAccount(int id) throws InvalidAccount {
        lockBank.lock();

        if (accounts.size() <= id || accounts.get(id).isClosed()){
            throw new InvalidAccount(id);
        }

        Account a = accounts.get(id);
        a.lock();

        float r = a.getBalance();
        a.close();

        a.unlock();
        lockBank.unlock();
        return r;
    }

    public void transfer(int from, int to, float amount) throws InvalidAccount, NotEnoughFunds {
        lockBank.lock();

        if (accounts.size() <= from || accounts.size() <= to){
            throw new InvalidAccount();
        }
        if (accounts.get(from).isClosed() || accounts.get(to).isClosed()){
            throw new InvalidAccount();
        }

        Account a0 = accounts.get(from);
        a0.lock();
        Account a1 = accounts.get(to);
        a1.lock();

        if (a0.getBalance() < amount){
            throw new NotEnoughFunds();
        }

        a0.credit(amount);
        a1.deposit(amount);

        a0.unlock();
        a1.unlock();
        lockBank.unlock();
    }

    public float totalBalance(int[] accounts) throws InvalidAccount {
        //TODO isto tem de fazer lock as contas todas do intervalo antes
        // de calcular o total, e depois voltar a fazer lock
        // Nao se pode usar check() pq o check faz locks
        float t = 0;
        lockBank.lock();

        for(int i : accounts){
            t += this.check(i);
        }

        lockBank.unlock();
        return t;
    }

    public void deposit(int id, float value) throws InvalidAccount {
        lockBank.lock();

        if (accounts.size() <= id || accounts.get(id).isClosed()){
            throw new InvalidAccount(id);
        }

        Account a = accounts.get(id);
        a.lock();

        a.deposit(value);

        a.unlock();
        lockBank.unlock();
    }

    public void credit(int id, float value) throws InvalidAccount {
        lockBank.lock();

        if (accounts.size() <= id || accounts.get(id).isClosed()){
            throw new InvalidAccount(id);
        }

        Account a = accounts.get(id);
        a.lock();

        a.credit(value);

        a.unlock();
        lockBank.unlock();
    }

    public float check(int id) throws InvalidAccount{
        lockBank.lock();

        if (accounts.size() <= id || accounts.get(id).isClosed()){
            throw new InvalidAccount(id);
        }

        Account a = accounts.get(id);
        a.lock();

        float r = a.getBalance();

        a.unlock();
        lockBank.unlock();

        return r;
    }
}
