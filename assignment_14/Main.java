//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*// 1)
        RunnableThread thread1 = new RunnableThread();

        Thread thread = new Thread(thread1);

        thread.start();
        thread.join();

        System.out.println(thread1.getSum());

        try {
            Counter counter = new Counter();

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= 100; i++) {
                        counter.count(i);
                    }
                }
            });

            thread.start();
            thread.join();


            System.out.println(counter.getSum());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 2)

        Thread1 thread = new Thread1();
        thread.start();
        thread.join();
        System.out.println(thread.getSum());
        */
        // 3)

        IncrementerCounter counter = new IncrementerCounter();

        Thread thread = new Thread(new Runnable() {
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
        });

        thread.start();

        System.out.println(counter.getSum());

        /*

        Calculator calculator = new Calculator(Integer.parseInt(args[0]));
        calculator.calculate(false);
        calculator.calculate(true);
        */
    }
}