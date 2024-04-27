package cmpt276Game.entities;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

/**
 * The type Puddles.
 */
public class Puddles extends Entity {
    private int damage;


    /**
     * Instantiates a new Puddles.
     *
     * @param x      the x
     * @param y      the y
     * @param gp     the gp
     * @param tm     the TileManager
     * @param damage the damage
     */
    public Puddles(int x, int y, GamePanel gp, TileManager tm, int damage){

        super(x, y, gp, tm, 16);
        this.damage = damage;
    }

    /**
     * Collided.
     * will decrease the player's score
     *
     * @param puddlesNum the puddles num
     */
    public void collided(int puddlesNum) {
        gp.score-=damage;
        gp.puddles.remove(puddlesNum);
    }
}