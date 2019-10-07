package Ex3_Banco2;

public class Banco {
    private Conta contas[];

    public Banco(int nContas) {
        this.contas = new Conta[nContas];

        for (int i = 0; i<nContas; i++){
            Conta c = new Conta(0);
            this.contas[i] = c;
        }
    }

    public Conta[] getContas() {
        return contas;
    }

    public void transfer(int c0, int c1, double value){
        int min = Math.min(c0, c1);
        int max = Math.max(c0, c1);
        synchronized (this.contas[min]) {
            synchronized (this.contas[max]) {
                this.contas[c0].credit(value);
                this.contas[c1].deposit(value);
            }
        }
    }

}
