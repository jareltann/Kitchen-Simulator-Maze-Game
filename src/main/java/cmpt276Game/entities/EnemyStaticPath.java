package cmpt276Game.entities;

import cmpt276Game.main.BoardManager;
import cmpt276Game.main.GamePanel;
import cmpt276Game.tile.TileManager;

public class EnemyStaticPath extends Enemies {

    public EnemyStaticPath(int x, int y, GamePanel gp, TileManager tm, BoardManager bm, Player player){
        super(x, y, gp, tm, bm, player);
    }
    public void update() {
        if(checkCollide()) {
            gp.gameOver = true;
        }


        if (direction == 1){
            if(y == 10){
                direction *= -1;
            } else {
                y --;
            }
        } else {
            if(y == 13){
                direction *= -1;
            } else {
                y ++;
            }
        }

        if (animationTick == 10)
            animationTick = 1;
        else
            animationTick++;

        checkTick();
    }
    
}
