package lecture6Threads.synchronization.double_counter;

public class SynchDoubleCounter {
    private long c1;
    private long c2;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public long value1() {
        return c1;
    }

    public long value2() {
        return c2;
    }

    public void inc1() {
        synchronized (lock1) {
            c1++;
        }
    }

    public synchronized void inc2() {
        synchronized (lock2) {
            c2++;
        }
    }

    public synchronized void dec1() {
        synchronized (lock1) {
            c1--;
        }
    }

    public synchronized void dec2() {
        synchronized (lock2) {
            c2--;
        }
    }
}
