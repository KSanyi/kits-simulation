package kits.simulation;

import java.util.Random;

import kits.simulation.util.FrequencyMap;

public class ElectionSimulation {

    public static void main(String[] args) {

        int N = 100;
        
        FrequencyMap<Candidate> frequencyMap = new FrequencyMap<>();
        for(int i=0;i<N;i++) {
            frequencyMap.put(new Poll().run());
        }
        
        System.out.println(frequencyMap.frequencyPercent(Candidate.CANDIDATE_1));
    }
    
}

class Poll {
    
    private static final double CANDIDATE_1_RATIO = 0.55;
    private static final int POLL_SIZE = 1000;
    
    private final Random random = new Random();
    
    Candidate run() {
        int votesForCandidate1 = 0;
        for(int i=0;i<POLL_SIZE;i++) {
            if(random.nextDouble() < CANDIDATE_1_RATIO) {
                votesForCandidate1++;
            }
        }
        return votesForCandidate1 > POLL_SIZE / 2 ? Candidate.CANDIDATE_1 : Candidate.CANDIDATE_2;
    }
}

enum Candidate {
    CANDIDATE_1, CANDIDATE_2;
} 
