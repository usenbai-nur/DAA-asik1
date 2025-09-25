package algorithms;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        Random rnd = new Random();

        int n = 1 << 15;
        int[] arr = rnd.ints(n, 0, 1_000_000).toArray();

        int[] copy1 = arr.clone();
        metrics.reset();
        long t1 = System.nanoTime();
        new MergeSort(metrics).sort(copy1);
        long t2 = System.nanoTime();
        System.out.println("MergeSort time: " + (t2 - t1) + " ns, depth=" + metrics.maxDepth);

        int[] copy2 = arr.clone();
        metrics.reset();
        t1 = System.nanoTime();
        new QuickSort(metrics).sort(copy2);
        t2 = System.nanoTime();
        System.out.println("QuickSort time: " + (t2 - t1) + " ns, depth=" + metrics.maxDepth);

    }
}
