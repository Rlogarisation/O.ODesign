package random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {


    @Test
    // 62 52 3 58 67 5 11 46
    void testSeedBattle4() {
        int[] result = {62, 52, 3, 58, 67, 5, 11, 46};
        Game gameA = new Game(4);
        
        for (int number : result) {
            boolean status = gameA.battle();
            boolean expectedStatus;
            if (number > 50) {
                expectedStatus = true;
            }
            else {
                expectedStatus = false;
            }
            assertEquals(expectedStatus, status);
        }
        
    }


    @Test
    // 39 13 98 5 43 89 20 23
    void testSeedBattleNeg4() {
        int[] result = {39, 13, 98, 5, 43, 89, 20, 23};
        Game gameA = new Game(-4);
        
        for (int number : result) {
            boolean status = gameA.battle();
            boolean expectedStatus;
            if (number > 50) {
                expectedStatus = true;
            }
            else {
                expectedStatus = false;
            }
            assertEquals(expectedStatus, status);
        }
        
    }

    @Test
    // 60 48 29 47 15 53 91 61
    void testSeedBattle0() {
        int[] result = {60, 48, 29, 47, 15, 53, 91, 61};
        Game gameA = new Game(0);
        
        for (int number : result) {
            boolean status = gameA.battle();
            boolean expectedStatus;
            if (number > 50) {
                expectedStatus = true;
            }
            else {
                expectedStatus = false;
            }
            assertEquals(expectedStatus, status);
        }
        
    }
}