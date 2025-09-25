package algorithms;

import java.util.Random;

public class QuickSort {
    private final Metrics m;
    private final Random rnd = new Random();

    public QuickSort(Metrics metrics) {
        this.m = metrics;
    }

    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int lo, int hi) {
        while (lo < hi) {
            m.incDepth();
            int p = partition(arr, lo, hi);
            int left = p - lo, right = hi - p;
            if (left < right) {
                quicksort(arr, lo, p - 1);
                lo = p + 1;
            } else {
                quicksort(arr, p + 1, hi);
                hi = p - 1;
            }
            m.decDepth();
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivotIndex = lo + rnd.nextInt(hi - lo + 1);
        swap(arr, lo, pivotIndex);
        int pivot = arr[lo];
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= hi && arr[i] <= pivot) { m.comparisons++; i++; }
            while (arr[j] > pivot) { m.comparisons++; j--; }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        m.moves += 3;
    }
}
