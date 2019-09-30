package Ex3_Banco2;

public class Banco {
    private Conta contas[];

    public Banco(int nContas) {
        this.contas = new Conta[nContas];
        for (Conta c : contas) {
            c = new Conta(0);
        }

        this.contas[0].deposit(1000);
    }

    public Conta[] getContas() {
        return contas;
    }

    public void deposit(int client, double value){
        this.contas[client].deposit(value);
    }

    public void credit(int client, double value){
        this.contas[client].credit(value);
    }

    public double check(int client){
        return this.contas[client].check();
    }

    public void transfer(int client1, int client2, double value){
        this.contas[client2].deposit(value);
        this.contas[client1].credit(value);
    }
}
