package algorithms;

import java.util.Random;

public class QuickSort {
    private int counter;
    private int depth;
    private Random rand = new Random();

    public Metrics sort(int[] arr) {
        counter = 0;
        depth = 0;
        long start = System.nanoTime();

        quickSort(arr, 0, arr.length - 1, 0);

        long end = System.nanoTime();
        return new Metrics(end - start, counter, depth, arr.length);
    }

    private void quickSort(int[] arr, int low, int high, int level) {
        depth = Math.max(depth, level);
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1, level + 1);
            quickSort(arr, p + 1, high, level + 1);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);

        int i = low;
        for (int j = low; j < high; j++) {
            counter++;
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
