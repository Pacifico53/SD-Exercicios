package Ex3_Banco;

public class Banco{
    private double contas[];

    public Banco(int nContas) {
        this.contas = new double[nContas];
        for (double c : contas) {
            c = 0;
        }

        this.contas[0] = 1000;
    }

    public double[] getContas() {
        return contas;
    }

    public void setContas(double contas[]) {
        this.contas = contas;
    }

    public synchronized void deposit(int client, double value){
        this.contas[client] += value;
    }

    public synchronized void credit(int client, double value){
        this.contas[client] -= value;
    }

    public synchronized double check(int client){
        return this.contas[client];
    }

    public synchronized void transfer(int client1, int client2, double value){
        this.contas[client2] += value;
        this.contas[client1] -= value;
    }
}
