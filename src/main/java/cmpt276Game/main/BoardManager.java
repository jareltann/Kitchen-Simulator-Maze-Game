package cmpt276Game.main;

import cmpt276Game.tile.Tile;

/*
 * Holds a 2d array of all tiles on the map
 */
public class BoardManager {
    GamePanel gp;
    public BoardSquare[][] map;

    /**
     * Constructor for BoardManager.
     * 
     * Initializes the 2d array of BoardSquares.
     * 
     * @param gp the game panel.
     */
    public BoardManager(GamePanel gp) {
        this.gp = gp;
        map = new BoardSquare[gp.maxScreenCol][gp.maxScreenRow];
        for(int i=0; i < gp.maxScreenRow; i ++) {
            for(int j=0; j < gp.maxScreenCol; j ++) {
                map[j][i] = new BoardSquare();
            }
        }
    }

    /**
     * Add a Tile to a given BoardSquare.
     * 
     * @param x the x index into the 2d array
     * @param y the y index into the 2d array
     * @param t the tile to be added
     */
    public void addItem(int x, int y, Tile t) {
        map[x][y].items.add(t);
    }

    /**
     * Get the size of the list of tiles in a given BoardSquare.
     * 
     * @param x the x index into the 2d array
     * @param y the y index into the 2d array
     * @return the size of the list of tiles in the BoardSquare
     */
    public int sizeOf(int x, int y) {
        return map[x][y].items.size();
    }

    /**
     * Get a specific tile in the list of tiles in a given BoardSquare.
     * 
     * @param x the x index into the 2d array
     * @param y the y index into the 2d array
     * @param i the index of the requested tile in the list of this BoardSquare
     * @return the specified tile
     */
    public Tile getTile(int x, int y, int i) {
        if (i < map[x][y].items.size())
            return map[x][y].items.get(i);
        
        System.out.println("Out of bounds");
        return null;
    }
}
