package lecture6Threads.synchronization;

public class SynchStaticMethodApp {
    public static void main(String[] args) {
        SynchStaticMethodApp e = new SynchStaticMethodApp();
        new Thread(() -> classMethod()).start();
        new Thread(() -> e.objectMethod()).start();
    }

    public synchronized static void classMethod() {  //только один поток может вызывать у данного класса synchronized static метод, синхронизация идёт по классу
        System.out.println("Synch Static Method START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Synch Static Method END");
    }

    public synchronized void objectMethod() {
        System.out.println("Synch Method START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Synch Method END");
    }
}
