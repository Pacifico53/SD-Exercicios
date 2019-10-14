package Ex1;

class NThreads implements java.lang.Runnable{
    private int n;

    public NThreads(int n) {
        this.n = n;
    }

    public void run() {
        for(int i = 1; i <= n; i++){
            System.out.println(i);
        }
    }
}
