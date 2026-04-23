public class IncrementerThread implements Runnable {
    private Counter counter;

    public IncrementerThread() {
        this.counter = new Counter();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= 1000; i++) {
                        counter.increment();
                    }
                }
            });

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getSum() {
        return counter.getSum();
    }
}
