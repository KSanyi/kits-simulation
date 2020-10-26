package kits.simulation.util;

public record Range(double start, double end) {

    public boolean contains(double value) {
        return start <= value && value <= end;
    }
    
}
