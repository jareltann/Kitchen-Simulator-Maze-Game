package cmpt276Game.entities;

import cmpt276Game.main.BoardManager;
import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

public abstract class Movable extends Entity {
    BoardManager bm;

    public Movable(int x, int y, GamePanel gp, TileManager tm, int tmNo, BoardManager bm) {
        super(x, y, gp, tm, tmNo);
        this.bm = bm;
    }

    /**
     * Runs every frame to make updates to the player. Moves the player and
     * checks for animation updates.
     */
    public abstract void update();

    /**
     * Checks a given tile for a wall or a table.
     * 
     * @param x x coordinate of the tile (not pixel coordinate)
     * @param y y coordinate of the tile (not pixel coordinate)
     * @return
     */
    protected boolean checkBarrier(int x, int y) {
        for(int i = 0; i < bm.sizeOf(x,y); i++) {
            if (bm.getTile(x, y, i).solid == true)
                return true;
        }

        return false;
    }
}
