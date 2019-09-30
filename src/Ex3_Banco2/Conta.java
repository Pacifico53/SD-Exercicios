package Ex3_Banco2;

public class Conta {
    private double money;

    public Conta(double money) {
        this.money = money;
    }

    public synchronized void deposit(double value){
        this.money += value;
    }

    public synchronized void credit(double value){
        this.money -= value;
    }

    public synchronized double check(){
        return this.money;
    }
}
