package Ex5_BoundedBuffer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int s = 10;

        BoundedBuffer b = new BoundedBuffer(s);
        Thread t1 = new Thread(new CP1(b));
        Thread t2 = new Thread(new CP2(b));

        t2.start();
        t1.start();

        t1.join();
        t2.join();

        b.print();
    }
}
