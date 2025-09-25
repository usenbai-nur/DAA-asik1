package algorithms;

import java.util.Arrays;

public class ClosestPair {
    private int counter;

    public Metrics findClosest(int[][] points) {
        counter = 0;
        long start = System.nanoTime();

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        double result = closest(points, 0, points.length - 1);

        long end = System.nanoTime();
        return new Metrics(end - start, counter, 0, points.length);
    }

    private double closest(int[][] points, int left, int right) {
        if (left >= right) return Double.MAX_VALUE;
        if (right - left == 1) {
            counter++;
            return distance(points[left], points[right]);
        }

        int mid = (left + right) / 2;
        double d1 = closest(points, left, mid);
        double d2 = closest(points, mid + 1, right);
        double d = Math.min(d1, d2);

        return d;
    }

    private double distance(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}
