package lecture7Threads;

public class ThreadExceptions {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 10;
                System.out.println(1);
                x = x / 0;
                System.out.println(2);
            }
        });
        //Thread.setDefaultUncaughtExceptionHandler(...); будет перехватывать исключения из всех потоков, а снизу только из конкретного
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
                System.out.println("Caught");
            }
        });
        t.start();
    }
}
