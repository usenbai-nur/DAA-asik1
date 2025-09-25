package algorithms;

public class Metrics {
    public long runTime;
    public long counter;
    public long depth;
    public long allocation;

    public Metrics(long runTime, long counter, long depth, long allocation) {
        this.runTime = runTime;
        this.counter = counter;
        this.depth = depth;
        this.allocation = allocation;
    }

    @Override
    public String toString() {
        return runTime + ";" + counter + ";" + depth + ";" + allocation;
    }
}
