package f_synchronize_nonatomic_operations;

public class MinMaxMetrics {
    
    // Add all necessary member variables
	private volatile long min,max;
    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
        // Add code here
    }

    /**
     * Adds a new sample to our metrics.
     */
    public synchronized void addSample(long newSample) {
        min = Math.min(min, newSample);
        max = Math.max(max, newSample);
    	
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return max;
    }
}

