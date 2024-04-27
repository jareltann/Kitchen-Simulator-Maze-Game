package cmpt276Game.entities;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

/**
 * The type Glow.
 */
public class Glow extends Entity {

    private int animationTick;

    /**
     * Constructor for glow.
     *
     * @param x  x coor
     * @param y  y coor
     * @param gp game panel to interact with
     * @param tm tile manager to interact with
     */
    public Glow(int x, int y, GamePanel gp, TileManager tm) {
        super(x, y, gp, tm, 9);
        animationTick = 0;
    }

    /**
     * Update the image of the glow and remove itself if the animation has ended.
     */
    public void update() {
        if(animationTick == 2)
            gp.glows.remove(this);
        
        img = tm.getTile(9 + animationTick);
        animationTick++;
    }
}
