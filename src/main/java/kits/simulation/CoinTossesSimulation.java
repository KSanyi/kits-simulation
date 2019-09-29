package kits.simulation;

import java.util.ArrayList;
import java.util.List;

import kits.simulation.util.Coin;

public class CoinTossesSimulation {

    private static final int N = 200_000;
    
    public static void main(String[] args) {

        Coin coin = new Coin();
        List<Result> results = new ArrayList<>();
        long headsCount = 0;
        for(int i=0;i<N;i++) {
            Coin.Side side = coin.toss();
            if(side == Coin.Side.HEAD) headsCount++;
            if(i % 100 == 0) {
                Result result = Result.calculate(i, headsCount);
                results.add(result);
                printResults(headsCount, i);
                System.out.println("Max diff: " + calculateMaxDiff(results));
            }
            //results.add(coin.toss());
        }
        
        //results.stream().map(Result::toString).forEach(System.out::println);
        //long headsCount = results.stream().filter(r -> r.equals(Coin.Side.HEAD)).count();
    }
    
    static long calculateMaxDiff(List<Result> results) {
        return results.stream().mapToLong(r -> r.diffFromExpectation).max().getAsLong();
    }

    private static void printResults(long headsCount, int i) {
        System.out.println("After " + i + " tosses: " + (headsCount - i / 2) + " " + (((double)headsCount/i) - 0.5));
    }
    
    private static class Result {
        final long n;
        final long diffFromExpectation;
        final double ratioDiffFromExpectation;
        
        public Result(long n, long diffFromExpectation, double ratioDiffFromExpectation) {
            this.n = n;
            this.diffFromExpectation = diffFromExpectation;
            this.ratioDiffFromExpectation = ratioDiffFromExpectation;
        }
        
        static Result calculate(long n, long headsCount) {
            return new Result(n, (headsCount - n / 2), ((double)headsCount/n) - 0.5);
        }
        
        @Override
        public String toString() {
            return "After " + n + " tosses: " + diffFromExpectation + " " + ratioDiffFromExpectation;
        }
    }

}
