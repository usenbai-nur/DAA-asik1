package algorithms;

public class MergeSort {
    private final Metrics m;

    public MergeSort(Metrics metrics) {
        this.m = metrics;
    }

    public void sort(int[] arr) {
        int[] buffer = new int[arr.length];
        mergeSort(arr, buffer, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] buffer, int lo, int hi) {
        if (hi - lo <= 32) { // cutoff to insertion sort
            insertionSort(arr, lo, hi);
            return;
        }
        m.incDepth();
        int mid = (lo + hi) >>> 1;
        mergeSort(arr, buffer, lo, mid);
        mergeSort(arr, buffer, mid + 1, hi);
        merge(arr, buffer, lo, mid, hi);
        m.decDepth();
    }

    private void merge(int[] arr, int[] buffer, int lo, int mid, int hi) {
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            m.comparisons++;
            if (arr[i] <= arr[j]) buffer[k++] = arr[i++];
            else buffer[k++] = arr[j++];
            m.moves++;
        }
        while (i <= mid) buffer[k++] = arr[i++];
        while (j <= hi) buffer[k++] = arr[j++];
        for (int t = lo; t <= hi; t++) arr[t] = buffer[t];
    }

    private void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > key) {
                m.comparisons++;
                arr[j + 1] = arr[j];
                j--;
                m.moves++;
            }
            arr[j + 1] = key;
            m.moves++;
        }
    }
}
