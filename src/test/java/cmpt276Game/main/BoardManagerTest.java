package cmpt276Game.main;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

import cmpt276Game.main.BoardManager;
import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.Tile;

public class BoardManagerTest {

    private BoardManager boardManager;
    private GamePanel gamePanel;
    
    @Before
    public void setup() {
    	
    	gamePanel = new GamePanel();
    	boardManager = new BoardManager(gamePanel);
    	
    }
    
    
    /**
     * Tests both addItem and sizeOf methods
     */
    @Test
    public void AddItemTest() {
    	
        Tile tile = new Tile();
        boardManager.addItem(0, 0, tile);
        assertEquals(1, boardManager.sizeOf(0, 0));
        
    }
    
    /**
     * Tests the getTile method
     */
    @Test
    public void getTile() {
        Tile tile = new Tile();
        boardManager.addItem(0, 0, tile);
        assertEquals(tile, boardManager.getTile(0, 0, 0));
        assertNull(boardManager.getTile(0, 0, 1));
    }

}
