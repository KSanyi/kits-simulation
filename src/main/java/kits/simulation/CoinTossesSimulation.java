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
                System.out.println(result);
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

    private static record Result(long n, long diffFromExpectation, double ratioDiffFromExpectation) {
        
        static Result calculate(long n, long headsCount) {
            return new Result(n, (headsCount - n / 2), ((double)headsCount/n) - 0.5);
        }
        
        @Override
        public String toString() {
            return String.format("After %d tosses: %d %.4f", n, diffFromExpectation, ratioDiffFromExpectation);
        }
    }

}
