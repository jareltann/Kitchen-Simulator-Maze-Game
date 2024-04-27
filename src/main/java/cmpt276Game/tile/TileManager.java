package cmpt276Game.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import cmpt276Game.main.GamePanel;
import cmpt276Game.main.BoardManager;

/*
 * Has a 2d array of numbers which represent each icon
 * The map is made by reading the array and drawing the corresponding icon to that tile.
 * It gets the icon image from the tile[] array.
 */
public class TileManager {

    GamePanel gp;
	BoardManager bm;
	Tile[] tile;
	int mapTileNum[][];
	
	/**
	 * Constructor for TileManager. 
	 * 
	 * Imports all the sprites and then loads the map.
	 * @param gp
	 * @param bm
	 */
	public TileManager(GamePanel gp, BoardManager bm) {
		
		this.gp = gp;
		this.bm = bm;
		
		tile = new Tile[22];
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
		getTileImage();
		// load each layer of the map
		loadMap("/maps/map01.txt");
		loadMap("/maps/map02.txt");
		loadMap("/maps/map03.txt");
		loadMap("/maps/map04.txt");
	}
	
	/**
	 * Loads all the sprites into the array tile[].
	 * 
	 * Each sprite is a Tile. The "solid" tag defines a tile that cannot be crossed over.
	 */
	public void getTileImage() {
		
		try {

			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].solid = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/doorClosed.png"));
			tile[2].solid = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/doorOpen.png"));
			tile[3].solid = true;
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/burnerA.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/burnerB.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/carrot.png"));
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/enemyChefA.png"));
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/enemyChefB.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/glowA.png"));
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/glowB.png"));
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grillTop.png"));

			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mainCharA.png"));
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mainCharB.png"));
			
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pan.png"));
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/potato.png"));
			
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/puddle.png"));
			
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/redbullA.png"));
			
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/redbullB.png"));
			
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sink.png"));
			
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/table.png"));
			tile[20].solid = true;
			
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/toast.png"));
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Parses the map data and loads the correct tiles into their respective spots in BoardManager.
	 * 
	 * @param filePath the txt file to be parsed into the map
	 */
	public void loadMap(String filePath) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxScreenCol) {
					
					String numbers[] = line.split(" ");
				
					int num = Integer.parseInt(numbers[col]);
					
					if(num != 100)
						bm.addItem(col, row, tile[num]);

					col++;
				}
				if(col == gp.maxScreenCol) {//gp hits 16
					
					col = 0;
					row++;
					
				}
			}
			br.close();
		}
		
		catch(Exception e) {
			
		}
	}

	/**
	 * Returns the requested Tile in the tile array.
	 * 
	 * @param i the index of the tile in the array
	 * @return the tile at index i in tile[]
	 */
	public Tile getTile(int i) {
		return tile[i];
	}
	
	/**
	 * Draws the whole background.
	 * 
	 * @param g2 the graphics component that allows drawing.
	 */
	public void draw(Graphics2D g2) {
		// Draw all items in each tile
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

			// Loops through the list of tiles in each board square and draws them
			for(int i=0; i < bm.sizeOf(col, row); i++) {
				g2.drawImage(bm.getTile(col, row, i).image, x, y, gp.tileSize, gp.tileSize, null);
			}

			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
	}
    
}
