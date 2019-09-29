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
    
}


