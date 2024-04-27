package cmpt276Game.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Checks for WASD keys being pressed/released.
 */

public class KeyHandler implements KeyListener {

	GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	/**
	 * Check when a key is pressed.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode(); //returns a number of the key that was pressed

		
		if (code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
		}

		if (code == KeyEvent.VK_ENTER)
			enterPressed = true;
		
	}

	/**
	 * Check when a key has been released.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}
}
