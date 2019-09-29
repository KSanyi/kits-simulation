package kits.simulation;

import java.util.Arrays;
import java.util.List;

import kits.simulation.util.Die;
import kits.simulation.util.FrequencyMap;

public class ThreeDiceSimulation {

    public static void main(String[] args) {

        int N = 100_000;
        
        List<Die> dice = Arrays.asList(new Die(), new Die(), new Die());
        FrequencyMap<Integer> frequencyMap = new FrequencyMap<>();
        for(int i=0;i<N;i++) {
            frequencyMap.put(rollDice(dice));
        }
        
        System.out.println(frequencyMap);
    }
    
    private static int rollDice(List<Die> dice) {
        return dice.stream().mapToInt(Die::roll).sum();
    }
    
}
