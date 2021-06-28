package lecture6Threads.race_condition;

public class Counter {
    private int c;

    public int value() {return c;}

    public Counter() {c = 0;}

    public void increment(){c++;}

    public void decrement(){c--;}
}
