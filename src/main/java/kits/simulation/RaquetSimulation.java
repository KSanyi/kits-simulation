package kits.simulation;

import java.util.Random;

import kits.simulation.RaquetGame.Player;
import kits.simulation.util.FrequencyMap;

public class RaquetSimulation {

    public static void main(String[] args) {
        
        int N = 1_000;
        
        FrequencyMap<Player> frequencyMap = new FrequencyMap<>();
        for(int i=0;i<N;i++) {
            frequencyMap.put(new RaquetGame().play());
        }
        
        System.out.println(frequencyMap.frequencyPercent(Player.PLAYER_1));
    }
    
}

class RaquetGame {
    
    private final int POINTS_FOR_WIN = 21;
    private final double PLAYER1_SERVE_WIN_PERCENT = 0.6;
    private final double PLAYER2_SERVE_WIN_PERCENT = 0.5;
    
    private int player1Points;
    private int player2Points;
    
    private Player server = Player.PLAYER_1;
    
    private final Random random = new Random();
    
    Player play() {
        
        while(!isOver()) {
            playPoint();
            //System.out.println(player1Points + " " + player2Points + " server: " + server);
        }
        
        return player1Points > player2Points ? Player.PLAYER_1 : Player.PLAYER_2;
    }
    
    private void playPoint() {
        if(server == Player.PLAYER_1) {
            if(random.nextDouble() < PLAYER1_SERVE_WIN_PERCENT) {
                player1Points++;
            } else {
                server = Player.PLAYER_2;
            }
        } else {
            if(random.nextDouble() < PLAYER2_SERVE_WIN_PERCENT) {
                player2Points++;
            } else {
                server = Player.PLAYER_1;
            }
        }
    }

    private boolean isOver() {
        return player1Points == POINTS_FOR_WIN || player2Points == POINTS_FOR_WIN;
    }

    enum Player {
        PLAYER_1, PLAYER_2;
    }
    
}
