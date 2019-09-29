package kits.simulation.util;

import java.util.Random;

public class Coin {

    private final Random random = new Random();
    
    public Side toss() {
        return Side.values()[random.nextInt(2)];
    }
    
    public enum Side {
        HEAD, TAIL;
    }
    
}
