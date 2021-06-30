package lecture8StreamAPI_Lambda;

public class LambdaExample {
    public static void main(String[] args) {

        /**
         * Создаётся анонимный внутренний класс, у которого нет имени, даётся временное имя MainApp$1, он реализует интерфейс
         * Runnable, и мы здесь прописываем как именно мы реализуем интерфейс - что должно быть в методе Run
         */
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        /**
         * Здесь получили лямбду
         */
        new Thread(

            () -> {


        }).start();

        doSomething(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Java");
            }
        });

        doSomething(()-> System.out.println());
    }

    public static void doSomething(Runnable runnableObj) {
        runnableObj.run();
    }
}
