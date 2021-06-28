package lecture6Threads.synchronization;

public class SynchMethodsApp {
    public static void main(String[] args) {
        SynchMethodsApp e1 = new SynchMethodsApp();
        SynchMethodsApp e2 = new SynchMethodsApp();
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method3()).start();
    }
// если используем synchronized в сигнатуре метода, то в роли монитора выступает объект, на котором был вызван метод
    public synchronized void method1() {
        System.out.println("M1-START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M1-END");
    }

    public synchronized void method2() {
        System.out.println("M2-START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2-END");
    }

    public void method3() {
        System.out.println("M3-START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M3-END");
    }

}
