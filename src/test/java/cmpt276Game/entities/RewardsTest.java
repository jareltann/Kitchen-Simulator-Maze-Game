package cmpt276Game.entities;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;
import cmpt276Game.main.BoardManager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple App.
 */
public class RewardsTest {
    private GamePanel testGamePanel;
    private BoardManager testBoardM;
    private TileManager testTileM;


    /**
     * Sets .
     */
    @BeforeEach
    void setup() {
        testGamePanel = new GamePanel();
        testBoardM = new BoardManager(testGamePanel);
        testTileM = new TileManager(testGamePanel, testBoardM);
        testGamePanel.rewards.add(new Rewards(0, 0, testGamePanel, testTileM, 25));
    }

    /**
     * Test collided removal.
     */
    @Test
    void testCollidedRemoval(){
        testGamePanel.rewards.get(0).collided(0);
        assertEquals(0, testGamePanel.rewards.size());
    }

    /**
     * Test collided score.
     */
    @Test
    void testCollidedScore(){
        int tempScore = testGamePanel.score;
        testGamePanel.rewards.get(0).collided(0);;
        assertEquals((tempScore+25), testGamePanel.score);
    }
}