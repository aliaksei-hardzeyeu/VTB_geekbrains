package lecture6Threads.home_work;

public class ThreadArray {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        //arraySimple();
        arrayThreads();
    }

    static void arraySimple() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println("Time working 1 : " + (b - a));
    }

    static void arrayThreads() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

         Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            }
        });



        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        long b = System.currentTimeMillis();

        System.out.println("Time working 2 : " + (b - a));
        System.out.println(arr[9999990]);

    }
}

