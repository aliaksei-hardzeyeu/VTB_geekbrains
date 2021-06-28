package lecture6Threads.synchronization.double_counter;

public class NotCorrectSynchDoubleCounter {
    private long c1 = 0;
    private long c2 = 0;
//такая форма не позволит вести параллельно работу с с1 и с2, так как при проведении любой операции с одной переменной, блокируются все операции
    public long value1() {return c1;}

    public long value2() {return c2;}

    public synchronized void inc1() {c1++;}
    public synchronized void inc2() {c2++;}

    public synchronized void dec1() {c1--;}
    public synchronized void dec2() {c2--;}

}
