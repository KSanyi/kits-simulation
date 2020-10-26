package kits.simulation;

import java.util.List;

public class GeometricBrownMotionSimulation {

    private static final int N = 100;
    
    public static void main(String[] args) {

        GBMGenerator generator = new GBMGenerator(100, 0.005, 0.02, N);
        
        List<Double> result = generator.generate();
        
        result.forEach(System.out::println);
        
        //CauchyGBMGenerator generator2 = new CauchyGBMGenerator(100, 0.005, 0.02, N);
        
        //result = generator2.generate();
        
        //result.forEach(System.out::println);
    }
    
}
