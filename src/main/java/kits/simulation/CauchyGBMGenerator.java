package kits.simulation;

import java.util.ArrayList;
import java.util.List;

import kits.simulation.util.RandomNumberGenerator;

public class CauchyGBMGenerator {

    private final double start;
    private final double mu;
    private final double sigma;
    private final int n;
    
    public CauchyGBMGenerator(double start, double mu, double sigma, int n) {
        this.start = start;
        this.mu = mu;
        this.sigma = sigma;
        this.n = n;
    }

    public List<Double> generate() {
        
        List<Double> result = new ArrayList<Double>(n);
        
        double x = start;
        for(int i=0;i<n;i++) {
            double yield = RandomNumberGenerator.generateBoundedCauchy(3) * sigma + mu;
            x = x * Math.exp(yield);
            result.add(x);
        }
        
        return result;
        
    }
    
}
