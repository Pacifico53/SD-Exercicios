package Ex4_BancoLocks;

public class Cliente2 implements Runnable{
    private int id;
    private Bank bank;

    public Cliente2(Bank bank, int id) {
        this.id = id;
        this.bank = bank;
    }

    public void run() {
        id = bank.createAccount(53);
        try {
            bank.transfer(id, 0, 50);
        } catch (InvalidAccount | NotEnoughFunds invalidAccount) {
            invalidAccount.printStackTrace();
        }
        System.out.println("Job\'s done. Id = "+ this.id+ ". 0 = " + bank.check(0));
    }
}
