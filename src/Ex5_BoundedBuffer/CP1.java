package Ex5_BoundedBuffer;

public class CP1 implements Runnable{
    private BoundedBuffer b;

    public CP1(BoundedBuffer b) {
        this.b = b;
    }

    @Override
    public void run(){
        for (int i = 0; i<25; i++){
            try {
                b.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
