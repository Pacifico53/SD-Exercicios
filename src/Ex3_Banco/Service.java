package Ex3_Banco;

public class Service implements Runnable {
    private Banco bank;
    private int id;

    public Service(Banco bank, int id) {
        this.bank = bank;
        this.id = id;
    }

    public void run() {
        if (id == 0){
            bank.transfer(0, 1, 1000);
            System.out.println("0: 0 = " + bank.check(0) + ". 1 = "+bank.check(1));
        }

        if (id == 1){
            bank.credit(1,  1000);
            System.out.println("1: 0 = " + bank.check(0) + ". 1 = "+bank.check(1));
        }
    }
}
