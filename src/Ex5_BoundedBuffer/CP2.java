package Ex5_BoundedBuffer;

public class CP2 implements Runnable{
    private BoundedBuffer b;

    public CP2(BoundedBuffer b) {
        this.b = b;
    }

    @Override
    public void run(){
        for (int i = 0; i<20; i++) {
            try {
                b.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
