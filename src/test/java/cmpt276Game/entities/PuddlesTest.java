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
public class PuddlesTest {
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
        testGamePanel.puddles.add(new Puddles(0, 0, testGamePanel, testTileM, 25));
    }

    /**
     * Test collided.
     */
    @Test
    void testCollided(){
        testGamePanel.puddles.get(0).collided(0);;
        assertEquals(0, testGamePanel.puddles.size());
    }

    /**
     * Test collided score.
     */
    @Test
    void testCollidedScore(){
        int tempScore = testGamePanel.score;
        testGamePanel.puddles.get(0).collided(0);;
        assertEquals((tempScore-25), testGamePanel.score);
    }
}