public class Thread1 extends Thread {
    private int sum;

    public Thread1() {
        this.sum = 0;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
