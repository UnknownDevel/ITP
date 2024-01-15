package ITP7;

public class ArrayCount {

    public static void main(String[] args) {
        int[] array = {100, 23, 7, 96, 1, 34, 56, 88, 10, 15};
        int length = array.length;

        int midpoint = length / 2;

        SumHolder sumHolder = new SumHolder();

        Thread thread1 = new SumThread(array, 0, midpoint, sumHolder);
        Thread thread2 = new SumThread(array, midpoint, length, sumHolder);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

            int totalSum = sumHolder.getSum1() + sumHolder.getSum1();
            System.out.println("Сумма элементов массива: " + totalSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SumHolder {
    private int sum1;

    public int getSum1() {
        return sum1;
    }

    public void setSum1(int sum1) {
        this.sum1 = sum1;
    }
}

class SumThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private SumHolder sumHolder;

    public SumThread(int[] array, int start, int end, SumHolder sumHolder) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.sumHolder = sumHolder;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }

        if (start == 0) {
            sumHolder.setSum1(sum);
        }
        else {
            sumHolder.setSum1(sum);
        }
    }
}

