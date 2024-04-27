package cmpt276Game.entities;

import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

/**
 * The type Bonus reward.
 */
public class BonusReward extends Rewards{

    //how long will the boost last if picked up, and how long until the bost deapear

    private int life;
    private int animationTick=0;

    /**
     * Instantiates a new Bonus reward.
     *
     * @param x     the x
     * @param y     the y
     * @param gp    the gp
     * @param tm    the tm
     * @param value the value
     * @param life  the life
     */
    public BonusReward(int x, int y, GamePanel gp, TileManager tm, int value, int life){
        super(x, y, gp, tm, value);
        this.img=tm.getTile(17);
        this.life = life;
    }


    /**
     * Decrease life.
     * will count down until 0, then be removed if not picked up
     *
     * @param rewardsNum the rewards num
     */
    public void decreaseLife(int rewardsNum) {
        if(life > 0)
            life--;
        else{
            gp.bonusRewards.remove(rewardsNum);
        }
        checkTick();
    }

    /**
     * Collided.
     * inrease the score when colled and remove itself
     *
     * @param rewardsNum the rewards num
     */
    public void collided(int rewardsNum) {
        gp.score+=value;
        gp.bonusRewards.remove(rewardsNum);
    }

    /**
     * checkTick
     * update the bonus rewards image each frame to simelate a anemation
     */
    private void checkTick() {
        if(animationTick == 0) {
            animationTick = 1;
            img = tm.getTile(17);
        }
        else {
            animationTick = 0;
            img = tm.getTile(18);
        }
    }

}
