package kits.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import kits.simulation.util.RandomNumberGenerator;

/**
 * 
 * Suppose that we have a sequence of occurrences. We assume that the time X between occurrences is
 *  a) exponentially distributed with lambda 0.1,
 *  b) uniformly distributed between 5 and 15,
 * so on the average, there is one occurrence every 10 minutes. You come upon this system at time 100,
 * and wait until the next occurrence. Make a conjecture concerning how long, on the average, you will have to wait.
 *
 */
public class WaitingTimesSimulation {

    public static void main(String[] args) {
        
        int N = 1000000;
        
        // a)
        List<Double> results = new ArrayList<>();
        for(int i=0;i<N;i++) {
            results.add(simulate(() -> RandomNumberGenerator.generateExponetial(0.1)));
        }
        results.stream().mapToDouble(d -> d).average().ifPresent(System.out::println);
        
        // b)
        results = new ArrayList<>();
        for(int i=0;i<N;i++) {
            results.add(simulate(() -> RandomNumberGenerator.generateUniform(5, 15)));
        }
        results.stream().mapToDouble(d -> d).average().ifPresent(System.out::println);
        
    }
    
    private static double simulate(Supplier<Double> generate) {
        double t = 0;
        while(t < 100) {
            t += generate.get();
        }
        return t - 100;
    }
    
}
