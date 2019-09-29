package kits.simulation.util;

public class Range {

    private final double start;
    
    private final double end;

    public Range(double start, double end) {
        this.start = start;
        this.end = end;
    }
    
    public boolean contains(double value) {
        return start <= value && value <= end;
    }
    
}
