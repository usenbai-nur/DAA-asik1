package algorithms;

public class MergeSort {
    private int counter;
    private int depth;

    public Metrics sort(int[] arr) {
        counter = 0;
        depth = 0;
        long start = System.nanoTime();

        mergeSort(arr, 0, arr.length - 1, 0);

        long end = System.nanoTime();
        return new Metrics(end - start, counter, depth, arr.length);
    }

    private void mergeSort(int[] arr, int left, int right, int level) {
        depth = Math.max(depth, level);

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, level + 1);
            mergeSort(arr, mid + 1, right, level + 1);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
            counter++;
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
            counter++;
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            counter++;
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
            counter++;
        }

        while (j < n2) {
            arr[k++] = R[j++];
            counter++;
        }
    }
}
