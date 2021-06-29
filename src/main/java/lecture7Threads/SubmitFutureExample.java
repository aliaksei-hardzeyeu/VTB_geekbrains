package lecture7Threads;

import java.util.concurrent.*;
//всё это нужно для вывода результата работы метода

public class SubmitFutureExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<String> stringFuture = service.submit(new Callable<String>() { //Future - результат работы ExecutorService
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
               // int x = 10 / 0;
                return "Java";
            }
        });

        try {
            String result = stringFuture.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
