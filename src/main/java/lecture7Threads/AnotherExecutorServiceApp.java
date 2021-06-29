package lecture7Threads;

import java.util.concurrent.*;

public class AnotherExecutorServiceApp {
    public static void main(String[] args) throws Exception{
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        Future<String> future = service.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(3000);
//                return "Java";
//            }
//        });
//
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("END");
//        service.shutdown();

        ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setPriority(10);
                t.setName("ABC");
                System.out.println("Created");
                System.out.println(t.getName());
                return t;
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        Thread.sleep(2000);
        service.execute(() -> System.out.println(2));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(3));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(4));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(5));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(6));

        service.shutdown();

    }
}
