package Ex4_BancoLocks;

class Cliente1 implements Runnable {
    private int id;
    private Bank bank;

    public Cliente1(Bank bank, int id) {
        this.id = id;
        this.bank = bank;
    }

    public void run() {
        id = bank.createAccount(0);
        bank.deposit(id, 100);
        System.out.println("Job\'s done. Id = "+ this.id + ". Money = " + bank.check(id));
    }
}
