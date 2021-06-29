package lecture7Threads;

import java.util.concurrent.Semaphore;

public class SimpleSemaphoreApp {
    public static void main(String[] args) {
        final Semaphore smp = new Semaphore(4);

        Runnable limitedCall = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                int time = 3 + (int) (Math.random() * 4.0);
                int num = count++;

                try {
                    smp.acquire();
                    System.out.println("Поток № " + num + "начинает выполнять очень долгое действие " + time + " сек.");
                    Thread.sleep(1000);
                    System.out.println("Поток № " + num + " завершил работу!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    smp.release();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }
}
