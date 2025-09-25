package algorithms;

import java.util.Arrays;

public class DeterministicSelect {
    private int counter;

    public Metrics select(int[] arr, int k) {
        counter = 0;
        long start = System.nanoTime();

        int value = selectHelper(arr, 0, arr.length - 1, k);

        long end = System.nanoTime();
        return new Metrics(end - start, counter, 0, arr.length);
    }

    private int selectHelper(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivot);

        int length = pivotIndex - left + 1;
        if (k == length) return arr[pivotIndex];
        else if (k < length) return selectHelper(arr, left, pivotIndex - 1, k);
        else return selectHelper(arr, pivotIndex + 1, right, k - length);
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) { left++; counter++; }
            while (arr[right] > pivot) { right--; counter++; }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++; right--;
            }
        }
        return left - 1;
    }

    private int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[left + n / 2];
        }

        int numMedians = (int) Math.ceil((double) n / 5);
        int[] medians = new int[numMedians];

        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(arr, subLeft, subRight + 1);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }

        return medianOfMedians(medians, 0, numMedians - 1);
    }
}
