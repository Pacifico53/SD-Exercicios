package Ex2;

public class Counter {
    public int n;

    public Counter(int n) {
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    //Estes 'synchronized' dao fix do programa!!!!!
    // Sem isto nao funciona bem com muitas threads
    public synchronized int getN() {
        return n;
    }

    public synchronized void inc(){
        n++;
    }
}
