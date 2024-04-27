package cmpt276Game.entities;

import org.junit.Test;

import cmpt276Game.tile.TileManager;
import cmpt276Game.main.GamePanel;
import cmpt276Game.main.KeyHandler;
import cmpt276Game.main.BoardManager;




/**
 * Unit test for simple App.
 */
public class EntityTest 
{
    
	
    /**
     * Entity test
     */
    @Test
    public void testEntity()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        Entity testEntity = new Entity(0,0,testPanel,testTileM,0);

        assert(testEntity instanceof Entity);
    }

    /**
     * Player test
     */
    @Test
    public void testPlayer()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        KeyHandler testKeyH = new KeyHandler();
        Player testPlayer = new Player(testPanel, testKeyH, testTileM, testBoardM);

        assert(testPlayer instanceof Player);
    }

    /**
     * Static test
     */
    @Test
    public void testStatic()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        KeyHandler testKeyH = new KeyHandler();
        Player testPlayer = new Player(testPanel, testKeyH, testTileM, testBoardM);
        EnemyStaticPath testStatic = new EnemyStaticPath( 0, 0, testPanel, testTileM, testBoardM, testPlayer);

        assert(testStatic instanceof EnemyStaticPath);
    }

    /**
     * Path test
     */
    @Test
    public void testPath()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        KeyHandler testKeyH = new KeyHandler();
        Player testPlayer = new Player(testPanel, testKeyH, testTileM, testBoardM);
        EnemyTracking testPath = new EnemyTracking( 0, 0, testPanel, testTileM, testBoardM, testPlayer);

        assert(testPath instanceof EnemyTracking);
    }

    /**
     * Rewards test
     */
    @Test
    public void testReward()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        Rewards testReward = new Rewards( 0, 0, testPanel, testTileM, 0);

        assert(testReward instanceof Rewards);
    }

    /**
     * Bonus Rewards test
     */
    @Test
    public void testBonusReward()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        BonusReward testBonusReward = new BonusReward( 0, 0, testPanel, testTileM, 0, 0);

        assert(testBonusReward instanceof BonusReward);
    }

    /**
     * Glow test
     */
    @Test
    public void testGlow()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        Glow testGlow = new Glow( 0, 0, testPanel, testTileM);

        assert(testGlow instanceof Glow);
    }

    /**
     * Puddles test
     */
    @Test
    public void testPuddles()
    {
        GamePanel testPanel = new GamePanel();
        BoardManager testBoardM = new BoardManager(testPanel);
        TileManager testTileM = new TileManager(testPanel, testBoardM);
        Puddles testPuddle = new Puddles( 0, 0, testPanel, testTileM, 0);

        assert(testPuddle instanceof Puddles);
    }
}
