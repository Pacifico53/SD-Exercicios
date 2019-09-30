package Ex3_Banco2;

public class Cliente2 implements Runnable {
    private Banco bank;
    private Conta conta;

    public Cliente2(Banco bank, Conta conta) {
        this.bank = bank;
        this.conta = conta;
    }

    public void run() {
        System.out.println("0 = " + bank.check(0)+ ". 1 = "+bank.check(1)+".");
    }
}
