package kits.simulation.util;

import java.util.Collection;

public record BaseStats(double min, double max, double avg, double stDev, long count) {

    public static BaseStats calculate(Collection<Double> values) {
        
        if(values.isEmpty()) throw new IllegalArgumentException("Can not calculate stats for empty values");
        
        final int count =  values.size();
        final double avg = values.stream().mapToDouble(v -> v).average().getAsDouble();
        
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double squareSum = 0;
        for(double x : values) {
            if(x < min) min = x;
            if(x > max) max = x;
            squareSum += (x - avg) * (x - avg);
        }
        final double stDev = Math.sqrt(squareSum / count);
        
        return new BaseStats(min, max, avg, stDev, count);
    }
    
}
