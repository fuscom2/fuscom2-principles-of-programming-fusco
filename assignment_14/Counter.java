public class Counter {
    private int sum;

    public Counter() {
        this.sum = 0;
    }

    public void count(int i) {
        sum += i;
    }

    public synchronized void increment() {
        sum++;
    }

    public int getSum() {
        return sum;
    }
}
