package cmpt276Game.main;

import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;


public class GamePanelTest {

	private GamePanel gamePanel;
	
	
	@Before
	public void setup() {
		gamePanel = new GamePanel();
	}
	
	
	/**
	 * Checks that the game has started
	 */
	@Test
	public void startGameThreadTest() {
		
		assertNull(gamePanel.gameThread);
		gamePanel.startGameThread();
		assertNotNull(gamePanel.gameThread);
		assertTrue(gamePanel.gameThread.isAlive());
		
	}
	
	/**
	 * Integration test to check that the game is over when won
	 */
	@Test
	public void checkGameOverWinTest() {
		

		
		gamePanel.startGameThread();
		assertFalse(gamePanel.gameOver);
		
		int i = gamePanel.rewards.size();
		
		while (i > 0) {
			gamePanel.rewards.remove(i-1);
			i--;
		}
		
		gamePanel.player.x = 18;
		gamePanel.player.y = 7;
		
		gamePanel.update();
		
		assertTrue(gamePanel.gameOver);
		assertTrue(gamePanel.win);
		
		
	}
	
	/**
	 * Integration test to check that game is over when lost
	 */
	@Test
	public void checkGameOverLoseTest() {
		
		gamePanel.startGameThread();
		assertFalse(gamePanel.gameOver);
		gamePanel.score--;
		gamePanel.update();
		assertTrue(gamePanel.gameOver);
		assertFalse(gamePanel.win);
		
	}
	
	
	
	/**
	 * Tests the run method and implicitly does integrate testing on other objects 
	 */
	@Test
	public void runTest() throws InterruptedException {
		
		//starts running the game
		gamePanel.startGameThread();
		//score should be 0 since game just started
		assertEquals(0,gamePanel.score);
		//should not be gameover yet since score is 0
		assertFalse(gamePanel.gameOver);
		//game should not have been won yet
	    assertFalse(gamePanel.win);

	    //all these objects should have already been instantiated
	    assertNotNull(gamePanel.player);
	    assertNotNull(gamePanel.tileM);
	    assertNotNull(gamePanel.boardM);
	    
	    //game should not be ended yet
	    assertNotNull(gamePanel.gameThread);
	
	}
	
	
}
