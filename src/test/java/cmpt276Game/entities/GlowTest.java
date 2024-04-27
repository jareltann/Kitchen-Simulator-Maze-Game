package cmpt276Game.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;
import cmpt276Game.main.BoardManager;

public class GlowTest {
    private GamePanel testGamePanel;
    private BoardManager testBoardM;
    private TileManager testTileM;
    private Glow testGlow;
    
    private void setup() {
		testGamePanel = new GamePanel();
        testBoardM = new BoardManager(testGamePanel);
        testTileM = new TileManager(testGamePanel, testBoardM);
        testGlow = new Glow(0, 0, testGamePanel, testTileM);
	}

    /**
     * Check update at tick 0
     */
    @Test
    void checkUpdateTick0() {
        this.setup();

        testGlow.update();

        assertEquals(testTileM.getTile(9), testGlow.img);
    }

    /**
     * Check update at tick 1
     */
    @Test
    void checkUpdateTick1() {
        this.setup();

        testGlow.update();
        testGlow.update();

        assertEquals(testTileM.getTile(10), testGlow.img);
    }

    /**
     * Check update at tick 2
     */
    @Test
    void checkUpdateTick2() {
        this.setup();

        testGamePanel.glows.add(testGlow);
        testGlow.update();
        testGlow.update();
        testGlow.update();

        assertEquals(0, testGamePanel.glows.size());
    }
}
