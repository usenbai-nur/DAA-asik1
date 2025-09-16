package algorithms;

public class Metrics {
    public long comparisons = 0;
    public long moves = 0;
    public int currentDepth = 0;
    public int maxDepth = 0;

    public void incDepth() {
        currentDepth++;
        Math.max(maxDepth, currentDepth);
    }
    public void decDepth() {
        currentDepth--;
    }
    public void reset(){
        comparisons = 0;
        moves = 0;
        currentDepth = 0;
        maxDepth = 0;
    }
}
