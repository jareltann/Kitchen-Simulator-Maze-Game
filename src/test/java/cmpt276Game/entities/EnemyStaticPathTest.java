package cmpt276Game.entities;

import cmpt276Game.main.GamePanel;
import cmpt276Game.main.KeyHandler;
import cmpt276Game.tile.TileManager;
import cmpt276Game.main.BoardManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple App.
 */
public class EnemyStaticPathTest {
    private GamePanel testGamePanel;
    private BoardManager testBoardM;
    private TileManager testTileM;
    private KeyHandler testKeyH;

    private Player testPlayer;

    /**
     * Sets .
     */
    @BeforeEach
    void setup() {
        testGamePanel = new GamePanel();
        testBoardM = new BoardManager(testGamePanel);
        testTileM = new TileManager(testGamePanel, testBoardM);
        testPlayer = new Player(testGamePanel, testKeyH, testTileM, testBoardM);
        testGamePanel.Enemies.add(new EnemyStaticPath(0, 11, testGamePanel, testTileM, testBoardM, testPlayer));
    }

    /**
     * Test enemy static path.
     */
    @Test
    void testEnemyStaticPath(){
        assertTrue(testGamePanel.Enemies.get(0) instanceof EnemyStaticPath);
    }

    /**
     * Test move down.
     */
    @Test
    void testMoveDown(){
        int y=testGamePanel.Enemies.get(0).y;
        testGamePanel.Enemies.get(0).update();
        assertEquals((y-1), testGamePanel.Enemies.get(0).y);
    }

    /**
     * Test move up.
     */
    @Test
    void testMoveUp(){
        int y=testGamePanel.Enemies.get(0).y;
        testGamePanel.Enemies.get(0).direction=-1;
        testGamePanel.Enemies.get(0).update();
        assertEquals((y+1), testGamePanel.Enemies.get(0).y);
    }

    /**
     * Test change direction to up.
     */
    @Test
    void testChangeDirectionToUp(){
        testGamePanel.Enemies.get(0).y=10;
        testGamePanel.Enemies.get(0).update();
        assertEquals(-1, testGamePanel.Enemies.get(0).direction);
    }

    /**
     * Test change direction to down.
     */
    @Test
    void testChangeDirectionToDown(){
        testGamePanel.Enemies.get(0).y=13;
        testGamePanel.Enemies.get(0).direction=-1;
        testGamePanel.Enemies.get(0).update();
        assertEquals(1, testGamePanel.Enemies.get(0).direction);
    }

    /**
     * Test game over.
     */
    @Test
    void testGameOver(){
        testPlayer.x=0;
        testPlayer.y=11;
        testGamePanel.Enemies.get(0).update();
        assertTrue(testGamePanel.gameOver);
    }
}