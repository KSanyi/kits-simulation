package kits.simulation.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();
    
    public static double generateUniform(double a, double b) {
        if(a > b) throw new IllegalArgumentException("a > b");
        
        return random.nextDouble() * (b - a) + a;
    }
    
    public static double generateExponetial(double lambda) {
        if(lambda < 0) throw new IllegalArgumentException("lambda < 0");
        
        return -Math.log(random.nextDouble()) / lambda;
    }
    
    public static double generateNormal(double mu, double sigma) {
        return random.nextGaussian() * sigma + mu;
    }
    
    public static double generateStNormal() {
        return generateNormal(0, 1);
    }
    
    public static double generateCauchy() {
        return Math.tan(Math.PI * (random.nextDouble() - 0.5));
    }
    
    public static double generateBoundedCauchy(double boundWidth) {
        double result = Double.MAX_VALUE;
        while(result < -boundWidth / 2 || result > boundWidth / 2) {
            result = Math.tan(Math.PI * (random.nextDouble() - 0.5));
        }
        return result;
    }
    
}


