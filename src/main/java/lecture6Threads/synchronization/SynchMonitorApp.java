package lecture6Threads.synchronization;

public class SynchMonitorApp {
    private Object monitor = new Object();

    public static void main(String[] args) {
        SynchMonitorApp e2 = new SynchMonitorApp();
        new Thread(() -> e2.method()).start();
        new Thread(() -> e2.method()).start();
        new Thread(() -> e2.method()).start();
    }

    public void method() {
        try {
            System.out.println("NON_SYNCH begin " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println(".");
                Thread.sleep(200);
            }
            System.out.println("NON_SYNCH end " + Thread.currentThread().getName());
            synchronized (monitor) {
                System.out.println("SYNCH begin" + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println(".");
                    Thread.sleep(200);
                }
                System.out.println("SYNCH end " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}