package cmpt276Game.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;
import cmpt276Game.main.KeyHandler;
import cmpt276Game.main.BoardManager;

public class PlayerTest {

    private GamePanel testGamePanel;
    private BoardManager testBoardM;
    private TileManager testTileM;
    private KeyHandler testKeyH;
    private Player testPlayer;

	private void setup() {
		testGamePanel = new GamePanel();
        testBoardM = new BoardManager(testGamePanel);
        testTileM = new TileManager(testGamePanel, testBoardM);
        testKeyH = new KeyHandler();
        testPlayer = new Player(testGamePanel, testKeyH, testTileM, testBoardM);
	}

    @Test
    void checkABarrierTile00() {
        this.setup();
        assertTrue(testPlayer.checkBarrier(0,0));
    }

    @Test
    void checkABarrierTile49() {
        this.setup();
        assertTrue(testPlayer.checkBarrier(4,9));
    }

    @Test
    void checkABarrierTile77() {
        this.setup();
        assertTrue(testPlayer.checkBarrier(7,7));
    }

    @Test
    void checkANonBarrierTile711() {
        this.setup();
        assertFalse(testPlayer.checkBarrier(7,11));
    }

    /**
     * Move up with a barrier in the way.
     */
    @Test
    void moveUpBarrier() {
        this.setup();
        testPlayer.x = 1;
        testPlayer.y = 1;
        testKeyH.upPressed = true;

        testPlayer.update();

        assertEquals(1, testPlayer.y);
        assertEquals(1, testPlayer.x);

        testKeyH.upPressed = false;
    }

    /**
     * Move up with no barrier in the way.
     */
    @Test
    void moveUpNoBarrier() {
        this.setup();
        testPlayer.x = 1;
        testPlayer.y = 2;
        testKeyH.upPressed = true;

        testPlayer.update();

        assertEquals(1, testPlayer.y);
        assertEquals(1, testPlayer.x);

        testKeyH.upPressed = false;
    }

    /**
     * Move down with a barrier in the way.
     */
    @Test
    void moveDownBarrier() {
        this.setup();
        testPlayer.x = 3;
        testPlayer.y = 14;
        testKeyH.downPressed = true;

        testPlayer.update();

        assertEquals(14, testPlayer.y);
        assertEquals(3, testPlayer.x);

        testKeyH.downPressed = false;
    }

    /**
     * Move down with no barrier in the way.
     */
    @Test
    void moveDownNoBarrier() {
        this.setup();
        testPlayer.x = 3;
        testPlayer.y = 13;
        testKeyH.downPressed = true;

        testPlayer.update();

        assertEquals(14, testPlayer.y);
        assertEquals(3, testPlayer.x);

        testKeyH.downPressed = false;
    }

    /**
     * Move left with a barrier in the way.
     */
    @Test
    void moveLeftBarrier() {
        this.setup();
        testPlayer.x = 1;
        testPlayer.y = 1;
        testKeyH.leftPressed = true;

        testPlayer.update();

        assertEquals(1, testPlayer.x);
        assertEquals(1, testPlayer.y);

        testKeyH.leftPressed = false;
    }

    /**
     * Move left with no barrier in the way.
     */
    @Test
    void moveLeftNoBarrier() {
        this.setup();
        testPlayer.x = 2;
        testPlayer.y = 1;
        testKeyH.leftPressed = true;

        testPlayer.update();

        assertEquals(1, testPlayer.x);
        assertEquals(1, testPlayer.y);

        testKeyH.leftPressed = false;
    }

    /**
     * Move right with a barrier in the way.
     */
    @Test
    void moveRightBarrier() {
        this.setup();
        testPlayer.x = 3;
        testPlayer.y = 14;
        testKeyH.rightPressed = true;

        testPlayer.update();

        assertEquals(3, testPlayer.x);
        assertEquals(14, testPlayer.y);

        testKeyH.rightPressed = false;
    }

    /**
     * Move right with no barrier in the way.
     */
    @Test
    void moveRightNoBarrier() {
        this.setup();
        testPlayer.x = 2;
        testPlayer.y = 14;
        testKeyH.rightPressed = true;

        testPlayer.update();

        assertEquals(3, testPlayer.x);
        assertEquals(14, testPlayer.y);

        testKeyH.rightPressed = false;
    }

    @Test
    void moveNowhere() {
        this.setup();
        testPlayer.x = 2;
        testPlayer.y = 14;

        testPlayer.update();

        assertEquals(2, testPlayer.x);
        assertEquals(14, testPlayer.y);
    }
    
    /**
     * Test CheckSquare() when there is a regular reward on the square.
     */
    @Test
    void checkSquareRegReward() {
        this.setup();
        testPlayer.x = 3;
        testPlayer.y = 2;

        testGamePanel.rewards.add(new Rewards(3, 2, testGamePanel, testTileM, 10));
        testPlayer.update();

        assertEquals(10, testGamePanel.score);

        testGamePanel.score = 0;
    }

    /**
     * Test CheckSquare() when there is a puddle on the square.
     */
    @Test
    void checkSquarePuddle() {
        this.setup();
        testPlayer.x = 13;
        testPlayer.y = 1;

        testGamePanel.puddles.add(new Puddles(13, 1, testGamePanel, testTileM, 10));
        testGamePanel.score = 10;
        testPlayer.update();

        assertEquals(0, testGamePanel.score);

        testGamePanel.score = 0;
    }

    /**
     * Test CheckSquare() when there is a bonus reward on the square.
     */
    @Test
    void checkSquareBonusReward() {
        this.setup();
        testPlayer.x = 1;
        testPlayer.y = 1;

        testGamePanel.bonusRewards.add(new BonusReward(1, 1, testGamePanel, testTileM, 25, 100));
        testPlayer.update();

        assertEquals(25, testGamePanel.score);

        testGamePanel.score = 0;
    }

    /**
     * Test CheckSquare() when there is nothing on the square.
     */
    @Test
    void checkSquareNothing() {
        this.setup();
        testPlayer.x = 2;
        testPlayer.y = 2;

        testPlayer.update();

        assertEquals(0, testGamePanel.score);
    }

}
