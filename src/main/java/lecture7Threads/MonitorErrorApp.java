package lecture7Threads;
//должен запускать все потоки одновременно, тк ссылка mon переприсваивается каждый раз при mon++, т е монитор для каждого объекта свой
public class MonitorErrorApp {
    private static Integer mon = 0;

    public static void main(String[] args) {
        new Thread(()-> {
            synchronized (mon) {
                System.err.println("1-start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("1-end");
            }
        }).start();

        new Thread(()-> {
            synchronized (mon) {
                System.err.println("2-start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("2-end");
            }
        }).start();

        new Thread(()-> {
            synchronized (mon) {
                System.err.println("3-start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("3-end");
            }
        }).start();
    }
}
