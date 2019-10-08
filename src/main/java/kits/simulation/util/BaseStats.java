package kits.simulation.util;

import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BaseStats {

    public final double min;
    public final double max;
    public final double avg;
    public final double stDev;
    public final long count;
    
    public BaseStats(double min, double max, double avg, double stDev, long count) {
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.stDev = stDev;
        this.count = count;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
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
