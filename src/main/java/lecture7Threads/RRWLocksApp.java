package lecture7Threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RRWLocksApp {
    public static void main(String[] args) {
        ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

        new Thread(() -> {
            rw1.readLock().lock();

            try {
                System.out.println("Reading-start-a");
                Thread.sleep(3000);
                System.out.println("Reading-end-a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                rw1.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rw1.readLock().lock();
                System.out.println("Reading-start-b");
                Thread.sleep(5000);
                System.out.println("Reading-end-b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rw1.readLock().unlock();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rw1.readLock().lock();
            try {

                System.out.println("Reading-start-c");
                Thread.sleep(3000);
                System.out.println("Reading-end-c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rw1.readLock().unlock();
            }
        }).start();


        new Thread(() -> {
            rw1.writeLock().lock();
            try {
                System.out.println("WRITING-start-a");
                Thread.sleep(3000);
                System.out.println("WRITING-end-a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rw1.writeLock().unlock();
            }
        }).start();

        new Thread(() -> {
            rw1.writeLock().lock();
            try {
                System.out.println("WRITING-start-b");
                Thread.sleep(3000);
                System.out.println("WRITING-end-b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rw1.writeLock().unlock();
            }
        }).start();

    }
}
