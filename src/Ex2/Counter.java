package Ex2;

public class Counter {
    public int n;

    public Counter(int n) {
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    //Este 'synchronized' dá fix do programa!!!!!
    // Sem isto nao funciona bem com muitas threads
    public synchronized void inc(){
        n++;
    }
}
