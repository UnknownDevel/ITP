package ITP7;

public class Matrixcheck {
    public static void main(String[] args) {
        int[][] matrix = {
                {-1, 15, 0},
                {99, 100, 88},
                {74, -150, 1}
        };
        int rows = matrix.length;
        MaxElementHolder maxElementHolder = new MaxElementHolder();
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new MaxThread(matrix[i], maxElementHolder);
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }

            int maxElement = maxElementHolder.getMaxElement();
            System.out.println(maxElement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MaxElementHolder {
    private int maxElement = Integer.MIN_VALUE;

    public synchronized int getMaxElement() {
        return maxElement;
    }
    public synchronized void updateMaxElement(int value) {
        if (value > maxElement) {
            maxElement = value;
        }
    }
}

class MaxThread extends Thread {
    private int[] row;
    private MaxElementHolder maxElementHolder;

    public MaxThread(int[] row, MaxElementHolder maxElementHolder) {
        this.row = row;
        this.maxElementHolder = maxElementHolder;
    }

    @Override
    public void run() {
        int maxInRow = Integer.MIN_VALUE;
        for (int value : row) {
            if (value > maxInRow) {
                maxInRow = value;
            }
        }
        maxElementHolder.updateMaxElement(maxInRow);
    }
}
