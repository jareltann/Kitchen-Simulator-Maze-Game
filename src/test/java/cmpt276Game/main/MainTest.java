package cmpt276Game.main;

import org.junit.Test;


import cmpt276Game.tile.TileManager;



/**
 * Unit test for simple App.
 */
public class MainTest 
{
    
    /**
     * gamePanel test
     */
    @Test
    public void testGamePanel()
    {
        GamePanel testPanel = new GamePanel();
        
        assert(testPanel instanceof GamePanel);
    }
    /**
     * BoardManager test
     */
    @Test
    public void testBoardManager()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        
        assert(testBoardM instanceof BoardManager);
    }

    /**
     * TileManager test
     */
    @Test
    public void testTileManager()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);

        assert(testTileM instanceof TileManager);
    }

    /**
     * KeyManager test
     */
    @Test
    public void testKeyManager()
    {
        KeyHandler testKeyH = new KeyHandler();

        assert(testKeyH instanceof KeyHandler);
    }

    /**
     * UI test
     */
    @Test
    public void testUI()
    {
        GamePanel testPanel = new GamePanel();
        UI testUI = new UI(testPanel);

        assert(testUI instanceof UI);
    }
}
