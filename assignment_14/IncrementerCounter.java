public class IncrementerCounter {
    private int sum;

    public IncrementerCounter() {
        this.sum = 0;
    }

    public synchronized void increment() {
        sum++;
    }

    public int getSum() {
        return sum;
    }
}
