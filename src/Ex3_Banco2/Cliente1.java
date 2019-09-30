package Ex3_Banco2;

public class Cliente1 implements Runnable {
    private Banco bank;
    private Conta conta;

    public Cliente1(Banco bank, Conta conta) {
        this.bank = bank;
        this.conta = conta;
    }

    public void run() {
        bank.transfer(0, 1, 1000);
    }

}
