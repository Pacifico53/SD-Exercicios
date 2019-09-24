package Ex2;

public class Incrementer implements java.lang.Runnable {
    private Counter c;
    private int maxI;

    public void run() {
        for(int i = 0; i<maxI;i++){
            c.inc();
        }
    }

    public Incrementer(Counter c, int maxI) {
        this.c = c;
        this.maxI = maxI;
    }
}
