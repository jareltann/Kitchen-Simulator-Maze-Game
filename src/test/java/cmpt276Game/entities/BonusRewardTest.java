package cmpt276Game.entities;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;
import cmpt276Game.main.BoardManager;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple App.
 */
public class BonusRewardTest {
    private GamePanel testGamePanel;
    private BoardManager testBoardM;
    private TileManager testTileM;
    private ArrayList<BonusReward> testBonusReward = new ArrayList<BonusReward>();;

    /**
     * Sets .
     */
    @BeforeEach
    void setup() {
        testGamePanel = new GamePanel();
        testBoardM = new BoardManager(testGamePanel);
        testTileM = new TileManager(testGamePanel, testBoardM);
        System.out.print(testBonusReward.size());
        testGamePanel.bonusRewards.add(new BonusReward(0, 0, testGamePanel, testTileM, 25, 1));
        System.out.print(testBonusReward.size());
    }


    /**
     * Test collided removal.
     */
    @Test
    void testCollidedRemoval(){
        testGamePanel.bonusRewards.get(0).collided(0);
        assertEquals(0, testGamePanel.bonusRewards.size());
    }

    /**
     * Test decrease life.
     */
    @Test
    void testDecreaseLife(){
        testGamePanel.bonusRewards.get(0).decreaseLife(0);
        testGamePanel.bonusRewards.get(0).decreaseLife(0);
        assertEquals(0, testGamePanel.bonusRewards.size());
    }

    /**
     * Test collided score.
     */
    @Test
    void testCollidedScore(){
        int tempScore = testGamePanel.score;
        testGamePanel.bonusRewards.get(0).collided(0);;
        assertEquals((tempScore+25), testGamePanel.score);
    }
}