import java.time.Duration;

public class Calculator {
    SumOfSquares sumOfSquares;
    int length;
    int sum = 0;
    int sum1 = 0;
    int sum2 = 0;


    public Calculator(int length) {
        this.sumOfSquares = new SumOfSquares(length);
        this.length = length;
        this.sum = 0;
    }

    public void calculate(boolean threaded) throws InterruptedException {
        long startTime = System.nanoTime();

        if (!threaded) {
            for (int i = 0; i < length; i++) {
                sum += sumOfSquares.calculateSquare(i);
            }
        } else {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i < length / 2; i++) {
                        sum1 += sumOfSquares.calculateSquare(i);
                    }

                    sum += sum1;
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = length / 2; i < length; i++) {
                        sum2 += sumOfSquares.calculateSquare(i);
                    }

                    sum += sum2;
                }
            });

            thread1.start();
            thread2.start();
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println(threaded ? "Threaded: " : "Not threaded: ");
        System.out.println("Sum: " + sum + ", Duration: " + duration);
    }
}
