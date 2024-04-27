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
public class EnemyTrackingTest {
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
        testGamePanel.Enemies.add(new EnemyTracking(10, 4, testGamePanel, testTileM, testBoardM, testPlayer));
        testGamePanel.Enemies.get(0).animationTick=5;
    }

    /**
     * Test enemy tracking.
     */
    @Test
    void testEnemyTracking(){
        assertTrue(testGamePanel.Enemies.get(0) instanceof EnemyTracking);
    }

    /**
     * Test game over.
     */
    @Test
    void testGameOver(){
        testPlayer.x=10;
        testPlayer.y=4;
        testGamePanel.Enemies.get(0).update();
        assertTrue(testGamePanel.gameOver);
    }

    /**
     * Test move enemy tracking right.
     */
    @Test
    void testMoveEnemyTrackingRight(){
        testPlayer.x=13;
        testGamePanel.Enemies.get(0).update();
        assertEquals(11, testGamePanel.Enemies.get(0).x);
    }

    /**
     * Test move enemy tracking left.
     */
    @Test
    void testMoveEnemyTrackingLeft(){
        testGamePanel.Enemies.get(0).update();
        assertEquals(9, testGamePanel.Enemies.get(0).x);
    }


    /**
     * Test move enemy tracking up.
     */
    @Test
    void testMoveEnemyTrackingUp(){
        testPlayer.y=1;
        testGamePanel.Enemies.get(0).update();
        assertEquals(3, testGamePanel.Enemies.get(0).y);
    }

    /**
     * Test move enemy tracking down.
     */
    @Test
    void testMoveEnemyTrackingDown(){
        testGamePanel.Enemies.get(0).update();
        assertEquals(5, testGamePanel.Enemies.get(0).y);
    }



}