package lecture7Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(10); //все операции с atomic являются атомарными
        ai.getAndAdd(3);

    }
}
