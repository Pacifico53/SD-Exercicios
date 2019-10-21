package Ex5_BoundedBuffer;

public class BoundedBuffer {
    private int size;
    private int[] array;

    public BoundedBuffer(int size) {
        this.size = 0;
        array = new int[size];
    }

    public int getSize() {
        return size;
    }

    public void put(int value) throws InterruptedException {
        synchronized (this) {
            while (this.array.length <= this.size) {
                wait();
            }

            array[size++] = value;
            notifyAll();
        }
    }

    public int get() throws InterruptedException {
        synchronized (this) {
            while (this.size <= 0) {
                wait();
            }

            size--;

            int v = array[size];
            notifyAll();
            return v;
        }
    }

    public void print(){
        for (int a : array) {
            System.out.println("Elemento " + a);
        }
        System.out.println("size = " + size);
    }
}
