package cmpt276Game.entities;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

/**
 * The type Rewards.
 */
public class Rewards extends Entity {
    /**
     * The Value of the reward
     */
    protected int value;


    /**
     * Instantiates a new Rewards.
     *
     * @param x     the x
     * @param y     the y
     * @param gp    the gp
     * @param tm    the tm
     * @param value the value
     */
    public Rewards(int x, int y, GamePanel gp, TileManager tm, int value){
        super(x, y, gp, tm, 15);
        this.value=value;
    }

    /**
     * Collided.
     * inrease the score when colled and remove itself
     *
     * @param rewardsNum the rewards num
     */
    public void collided(int rewardsNum) {
        gp.score+=value;
        gp.rewards.remove(rewardsNum);
    }
}
