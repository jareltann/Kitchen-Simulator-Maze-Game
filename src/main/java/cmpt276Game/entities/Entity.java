package cmpt276Game.entities;

import cmpt276Game.tile.Tile;
import cmpt276Game.tile.TileManager;
import java.awt.Graphics2D;
import cmpt276Game.main.GamePanel;

/**
 * The type Entity.
 */
public class Entity {
    /**
     * The Gp is the GamePanel that will have everything operate in.
     */
    protected GamePanel gp;
    /**
     * The X.
     */
    public int x; // x,y represents the tile the entity is on, not the pixel coordinates.
    /**
     * The Y.
     */
    public int y;
    /**
     * The Img.
     */
    Tile img; // the sprite of the entity, get this from TileManager

    /**
     * The TileManager to determain what image to use.
     */
    protected TileManager tm;

    /**
     * Instantiates a new Entity.
     *
     * @param x    the x
     * @param y    the y
     * @param gp   the gp
     * @param tm   the tm
     * @param tmNo the tm no
     */
    public Entity(int x, int y, GamePanel gp, TileManager tm, int tmNo){
        this.x=x;
        this.y=y;
        this.gp = gp;
        this.tm = tm;
        this.img=tm.getTile(tmNo);
    }

    /**
     * Entity draws itself to the board.
     *
     * @param g2 the graphics component that allows drawing.
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(img.image, x*gp.tileSize, y*gp.tileSize, gp.tileSize, gp.tileSize, null);
    }
}
