package Ex4_BancoLocks;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public int createAccount(float initialBalance){
        Account a = new Account(initialBalance);
        accounts.add(a);
        return accounts.indexOf(a);
    }

    public float closeAccount(int id) throws InvalidAccount {
        if (accounts.size() <= id || accounts.get(id).isClosed()){
            throw new InvalidAccount();
        }

        Account a = accounts.get(id);
        float r = a.getBalance();
        a.close();
        return r;
    }

    public void transfer(int from, int to, float amount) throws InvalidAccount, NotEnoughFunds {
        Account a0 = accounts.get(from);
        Account a1 = accounts.get(to);

        a0.credit(amount);
        a1.deposit(amount);
    }

    public float totalBalance(int accounts[]) {
        float total = 0;
        for(int i : accounts){
            total += this.accounts.get(i).getBalance();
        }
        return total;
    }
}
