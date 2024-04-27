package cmpt276Game.entities;

import cmpt276Game.main.KeyHandler;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

import java.util.ArrayList;

import cmpt276Game.main.BoardManager;

/**
 * The type Player.
 */
public class Player extends Movable {
    KeyHandler keyH;
    /**
     * The Animation tick.
     */
    int animationTick;
    /**
     * The Enemies.
     */
    ArrayList<Enemies> enemies;
    /**
     * The Puddles.
     */
    ArrayList<Puddles> puddles;
    /**
     * The Rewards.
     */
    ArrayList<Rewards> rewards;

    /**
     * Constructor for player.
     * <p>
     * Initializes starting position and image.
     *
     * @param gp   the game panel used to manage the game
     * @param keyH a key listener to check for key strokes
     * @param tm   tile manager to access the player's sprite
     * @param bm   board manager to access the background
     */
    public Player(GamePanel gp, KeyHandler keyH, TileManager tm, BoardManager bm) {
        super(1, 7, gp, tm, 12, bm);
		this.keyH = keyH;
        animationTick = 0;
	}


    /**
     * Runs every frame to make updates to the player. Moves the player and
     * checks for animation updates.
     */
    public void update() {
		if (keyH.upPressed == true) {
			//direction = "up";
            if(checkBarrier(x, y-1) == false) 
			    y -= 1;
		}
		
		else if (keyH.downPressed == true) {
			//direction = "down";
            if(checkBarrier(x, y+1) == false)
			    y += 1;
		}
		
		else if (keyH.leftPressed == true) {
			//direction = "left";
            if(checkBarrier(x-1, y) == false)
			    x -= 1;
		}
		
		else if (keyH.rightPressed == true) {
			//direction = "right";
            if(checkBarrier(x+1, y) == false)
			    x += 1;
		}

        checkTick();

        checkSquare();
	}

    // /**
    //  * Updates the global score by the given amount.
    //  * 
    //  * @param amt amount to add to the score.
    //  */
    // private void updateScore(int amt) {
    //     gp.score += amt;
    // }

    /**
     * Updates the player's image on each frame.
     */
    private void checkTick() {
        if(animationTick == 0) {
            animationTick = 1;
            img = tm.getTile(13);
        }
        else {
            animationTick = 0;
            img = tm.getTile(12);
        }
    }

    /**
     * Check the current square for any rewards or puddles.
     */
    private void checkSquare() {
        for(int i=0; i<gp.rewards.size(); i++) {
            Rewards temp = gp.rewards.get(i);
            if( (temp.x == this.x) && (temp.y == this.y)) {
                temp.collided(i);
                gp.glows.add(new Glow(this.x, this.y, this.gp, this.tm));
            }
        }

        for(int i=0; i<gp.bonusRewards.size(); i++) {
            Rewards temp = gp.bonusRewards.get(i);
            if( (temp.x == this.x) && (temp.y == this.y)) {
                temp.collided(i);
                gp.glows.add(new Glow(this.x, this.y, this.gp, this.tm));
            }
        }

        for(int i=0; i<gp.puddles.size(); i++) {
            Puddles temp = gp.puddles.get(i);
            if( (temp.x == this.x) && (temp.y == this.y)) {
                temp.collided(i);
            }
        }
    }
}
