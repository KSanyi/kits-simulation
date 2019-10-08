package kits.simulation;

import java.util.ArrayList;
import java.util.List;

import kits.simulation.util.BaseStats;
import kits.simulation.util.RandomNumberGenerator;

public class CauchySimulation {

    public static void main(String[] args) {

        int N = 100;
        List<Double> results = new ArrayList<>();
        for(int i=0;i<N;i++) {
            results.add(RandomNumberGenerator.generateCauchy());
        }
        
        System.out.println(BaseStats.calculate(results));
        
        results = new ArrayList<>();
        for(int i=0;i<N;i++) {
            results.add(RandomNumberGenerator.generateBoundedCauchy(3));
        }
        
        System.out.println(BaseStats.calculate(results));
    }
    
}
