package Ex3_Banco2;

class Cliente1 implements Runnable {
    private Banco bank;
    private Conta conta;

    public Cliente1(Banco bank, Conta conta) {
        this.bank = bank;
        this.conta = conta;

    }

    public void run() {
        this.conta.deposit(1000);
        bank.transfer(0,  1, 1000);
        this.conta.deposit(53);
        System.out.println("Cliente 1 feito, conta 1 tem = " + this.conta.check());
    }

}
