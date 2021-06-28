package lecture6Threads;

public class DaemonExample {
    public static void main(String[] args) {
        Thread tTimer = new Thread(() -> {
            int time = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println("time: " + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tTimer.setDaemon(true); //потоки демоны работают до тех пор, пока работает хоть один обычный поток в приложении
                                //также у них нет привязки к порождающему их потоку, если его обрубить, но будут другие обычные потоки
                                //демоны будут работать см 1е условие
        tTimer.start();
        System.out.println("main -> sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main -> end");
    }
}
