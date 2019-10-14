package Ex4_BancoLocks;

class Cliente1 implements Runnable {
    private int id;
    private Bank bank;

    public Cliente1(Bank bank) {
        this.id = 0;
        this.bank = bank;
    }

    public void run() {
        int a;

        for(int i = 0; i<10; i++){
            a = bank.createAccount(i);
        }

        try {
            bank.closeAccount(3);
        } catch (InvalidAccount invalidAccount) {
            invalidAccount.printStackTrace();
        }

        a = bank.createAccount(31);
        a = bank.createAccount(99);

        for (int i = 0; i<11; i++){
            try {
                System.out.println("id = " + i + ". money = " + bank.check(i));
            } catch (InvalidAccount invalidAccount) {
                invalidAccount.printStackTrace();
            }
        }

        /*
        id = bank.createAccount(0);
        bank.deposit(id, 100);
        System.out.println("Id = "+ this.id + ". Money = " + bank.check(id));

        try {
            bank.closeAccount(this.id);
        } catch (InvalidAccount invalidAccount) {
            System.out.println("as");
            invalidAccount.printStackTrace();
        }

        id = 10;

        this.id = bank.createAccount(499);
        System.out.println("After closing and reopening, new id = "+this.id +". Money = " + bank.check(this.id));
        */
    }
}
