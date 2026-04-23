public class SumOfSquares {
    private int[] arr;
    private int sum;

    public SumOfSquares(int length) {
        this.arr = new int[length];
        this.sum = sum;

        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = (int) (Math.random() * 100);
        }
    }

    public synchronized int calculateSquare(int i) {
        return (int) Math.pow(arr[i], 2);
    }

    public int getSum() {
        return sum;
    }
}
