package lecture6Threads.race_condition;

public class SynchCounterApp {
    public static void main(String[] args) {
        SynchCounter counter = new SynchCounter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.decrement();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        incThread.start();
        decThread.start();
        try {
            incThread.join(); //при этом сначала работает первый join - main входит в режим ожидания завершения первого потока и только после его
                              //завершения срабатывает ожидание завершения второго потока. Одновременно join не работает.
                              //при этом, если первый поток работает дольше второго, то main ждёт именно его завершения, а в это время второй завершается
                              //и код decThread.join() просто проскакивается:))
            decThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter = " + counter.value());

    }
}
