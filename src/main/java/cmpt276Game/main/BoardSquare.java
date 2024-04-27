package cmpt276Game.main;

import java.util.ArrayList;

import cmpt276Game.tile.Tile;

/*
 * Represents 1 specific square on the board. Holds all of this square's tiles
 */
public class BoardSquare {
    public ArrayList<Tile> items;

    /**
     * Constructor for BoardSquare.
     * 
     * Initialize the arraylist holding all the tiles.
     */
    public BoardSquare() {
        items = (ArrayList<Tile>) new ArrayList<Tile>();
    }
}
