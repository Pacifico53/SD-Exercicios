package Ex3_Banco2;

class Cliente2 implements Runnable {
    private Banco bank;
    private Conta conta;

    public Cliente2(Banco bank, Conta conta) {
        this.bank = bank;
        this.conta = conta;
    }

    public void run() {
        this.conta.credit(500);
        System.out.println("Cliente 2 feito, conta 2 tem = " + this.conta.check());
    }
}
