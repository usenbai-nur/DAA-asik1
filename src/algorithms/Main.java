package algorithms;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("results.csv")) {
            writer.write("algorithmName;runTime;counter;depth;allocation\n");

            int[] arr = {5, 2, 9, 1, 6};

            MergeSort ms = new MergeSort();
            Metrics m1 = ms.sort(arr.clone());
            writer.write("MergeSort;" + m1 + "\n");

            QuickSort qs = new QuickSort();
            Metrics m2 = qs.sort(arr.clone());
            writer.write("QuickSort;" + m2 + "\n");

            DeterministicSelect ds = new DeterministicSelect();
            Metrics m3 = ds.select(arr.clone(), 2);
            writer.write("DeterministicSelect;" + m3 + "\n");

            ClosestPair cp = new ClosestPair();
            Metrics m4 = cp.findClosest(new int[][]{{0,0},{1,1},{2,2}});
            writer.write("ClosestPair;" + m4 + "\n");
        }
    }
}
