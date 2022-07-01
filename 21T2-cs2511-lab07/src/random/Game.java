package random;

import java.util.Random;

/**
 * A simple game, where a hero engages in battles.
 * The hero has an equally likely chance of succeeding as of failing.
 * @author Nick Patrikeos + Zheng Luo
 */
public class Game {

    private double chanceOfWinning = 50;
    private Random random;

    public Game(long seed) {
        random = new Random(seed);
    }

    public Game() {
        this(System.currentTimeMillis());
    }

    /**
     * This function should return true if the hero wins the battle 
     * and false if they lose. 
     * The chance of the hero winning is 0.5
     */
    public boolean battle() {
        if (random.nextInt(100) > chanceOfWinning) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Game g = new Game();
        for (int i = 0; i < 100; i++) {
            if (g.battle()) {
                System.out.println("We won!! You are awesome!!");
            } else {
                System.out.println("Lost :(");
            }
        }
    }
}