public class RunnableThread implements Runnable {
    private int sum;

    public RunnableThread() {
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
