package kits.simulation;

import kits.simulation.util.Coin;
import kits.simulation.util.Range;

public class CoinTossesSimulation2 {

    private static final int N = 100;
    private static final int n = 100;
    
    public static void main(String[] args) {

        double delta = 0.1;
        Range range = new Range(0.5 - delta, 0.5 + delta);
        
        int inRangeCount = 0;
        for(int i=0;i<N;i++) {
            long numberOfHeads = nCoinTosses(n);
            double ratio = ((double)numberOfHeads) / n;
            if(range.contains(ratio)) inRangeCount++;
        }
        
        System.out.println(((double)inRangeCount) / N);
    }
    
    private static long nCoinTosses(long n) {
        Coin coin = new Coin();
        long headsCount = 0;
        for(int i=0;i<n;i++) {
            if(coin.toss() == Coin.Side.HEAD) headsCount++;
        }
        return headsCount;
    }
}
