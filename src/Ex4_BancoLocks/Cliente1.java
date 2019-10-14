package Ex4_BancoLocks;

class Cliente1 implements Runnable {
    private int id;
    private Bank bank;

    public Cliente1(Bank bank) {
        this.id = 0;
        this.bank = bank;
    }

    public void run() {
        for(int i = 0; i<10; i++){
            id = bank.createAccount(i);
        }

        try {
            bank.closeAccount(3);
        } catch (InvalidAccount invalidAccount) {
            invalidAccount.printStackTrace();
        }

        id = bank.createAccount(31);
        id = bank.createAccount(99);

        bank.deposit(1, 5);

        for (int i = 0; i<11; i++){
            try {
                System.out.println("id = " + i + ". money = " + bank.check(i));
            } catch (InvalidAccount invalidAccount) {
                invalidAccount.printStackTrace();
            }
        }
    }
}
