package cmpt276Game.entities;


import cmpt276Game.main.BoardManager;
import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

public class EnemyTracking extends Enemies {

    public EnemyTracking(int x, int y, GamePanel gp, TileManager tm, BoardManager bm, Player player) {
        super(x, y, gp, tm, bm, player);
    }
    public void update() {
        if(checkCollide()) {
            gp.gameOver = true;
        }

        if( (animationTick % 5) == 0) {
            if (this.x > target.x) {
                // try to move left
                if(checkBarrier(x-1, y) == false)
                    x --;
            }

            else if (this.x < target.x) {
                // try to move right
                if(checkBarrier(x+1, y) == false)
                    x ++;
            }

            if (this.y < target.y) {
                // try to move down
                if(checkBarrier(x, y+1) == false)
                    y++;
            }

            else if (this.y > target.y) {
                // try to move up
                if(checkBarrier(x, y-1) == false)
                    y--;
            }
        }


        if (animationTick == 10)
            animationTick = 1;
        else
            animationTick++;

        checkTick();
    }
}
