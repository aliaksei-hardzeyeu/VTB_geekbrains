package lecture6Threads.race_condition;

public class SynchCounter {
    private int c;

    public int value() {return c;}

    public SynchCounter() {c = 0;}

    public synchronized void increment(){c++;}

    public synchronized void decrement(){c--;}
}
