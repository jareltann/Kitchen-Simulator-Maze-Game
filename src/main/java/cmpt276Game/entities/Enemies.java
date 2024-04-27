package cmpt276Game.entities;

//import java.awt.Graphics2D;

import cmpt276Game.main.KeyHandler;
import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;
import cmpt276Game.main.BoardManager;


/**
 * The type Enemies.
 */
public abstract class Enemies extends Movable {

    /**
     * The Key h hands.
     */
    KeyHandler keyH;
    /**
     * The Bm.
     */
    BoardManager bm;
    /**
     * The Animation tick.
     */
    int animationTick;
    /**
     * The Path bool to figure out the path.
     */
    int pathBool, /**
     * The Direction.
     */
    direction;

    /**
     * The Target the plaeyer to get to him and demand the lamb sauce.
     */
    protected Player target;

    /**
     * Constructor for enemy.
     *
     * @param x      x coor
     * @param y      y coor
     * @param gp     game panel to interact with
     * @param tm     tile manager to interact with
     * @param bm     board manager to interact with
     * @param path   type of enemy, 0 is path, 1 is seeking
     * @param player entity to target
     */
    public Enemies(int x, int y, GamePanel gp, TileManager tm, BoardManager bm, Player player) {
        super(x, y, gp, tm, 7, bm);
        this.bm = bm;
        this.target = player;
        animationTick = 1;
        direction = 1;
	}

    /**
     * Update position and image of the enemy while checking for barriers and player.
     */
    public abstract void update();

    /**
     * Update the image of the enemy based on the tick.
     */
    protected void checkTick() {
        if( (animationTick % 2) == 0) {
            img = tm.getTile(7);
        }
        else {
            img = tm.getTile(8);
        }
    }

    /**
     * Check for a collision with the player on the current tile.
     *
     * @return true if the player is on the enemy's tile.
     */
    public boolean checkCollide(){
        if(this.x == target.x && this.y == target.y){
            return true;
        }

        return false;
    }
}
