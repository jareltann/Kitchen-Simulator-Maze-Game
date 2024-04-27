package cmpt276Game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.lang.Math;

import javax.swing.JPanel;

import cmpt276Game.entities.BonusReward;
import cmpt276Game.entities.Player;
import cmpt276Game.entities.Puddles;
import cmpt276Game.entities.Rewards;
import cmpt276Game.entities.Enemies;
import cmpt276Game.entities.EnemyStaticPath;
import cmpt276Game.entities.EnemyTracking;
import cmpt276Game.entities.Glow;
import cmpt276Game.tile.TileManager;

/**
 * Sets screen size and number of tiles.
 * Has the actual game loop that runs.
 * Draws everything each tick
 */
public class GamePanel extends JPanel implements Runnable {

    // screen settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3; //scales every asset by an arbitrary value to better fit the screen

	final int rewardsValue = 10;
	public final int tileSize = originalTileSize * scale; // actual scale
	public final int maxScreenCol = 20; //set the size for the game board
	public final int maxScreenRow = 16;
	public final int screenWidth = tileSize*maxScreenCol; //set the size for the screen
	public final int screenHeight = tileSize*maxScreenRow;

	// Game managing settings
	public int score = 0; 
	public boolean gameOver = false;
	public boolean win = false;
	public boolean start = false;
	
	// FPS
	int FPS = 10;
	
	// Entities and manager objects for the game
	BoardManager boardM = new BoardManager(this);
	TileManager tileM = new TileManager(this, boardM);
	KeyHandler keyH = new KeyHandler();
	public UI ui = new UI(this);
	Thread gameThread;
	Player player = new Player(this,keyH, tileM, boardM);

	//creates array lists of the various entities 
	public ArrayList<Enemies> Enemies = new ArrayList<Enemies>(); 
	public ArrayList<Rewards> rewards = new ArrayList<Rewards>();
	public ArrayList<BonusReward> bonusRewards = new ArrayList<BonusReward>();
	public ArrayList<Puddles> puddles = new ArrayList<Puddles>();
	public ArrayList<Glow> glows = new ArrayList<Glow>();

	public ArrayList<Integer> bonusRewardsX = new ArrayList<Integer>();
	public ArrayList<Integer> bonusRewardsY = new ArrayList<Integer>();
	
	/**
	 * Constructor for game panel.
	 * 
	 * Sets the screen size, background and other parameters.
	 */
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(new Color(0, 0, 0, 0));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true); //GamePanel can be 'focused' to receive key input
	}
	
	/**
	 * Starts the game thread and creates some starting entities.
	 */
	public void startGameThread() {
		//bonus rewards location
		//top right
		bonusRewardsX.add(1);
		bonusRewardsY.add(1);

		//bottom right
		bonusRewardsX.add(18);
		bonusRewardsY.add(13);
		//next to the tables on the right
		bonusRewardsX.add(10);
		bonusRewardsY.add(6);
		//next to the tables on the left
		bonusRewardsX.add(3);
		bonusRewardsY.add(6);
		//top of the table
		bonusRewardsX.add(8);
		bonusRewardsY.add(3);
		//below the table
		bonusRewardsX.add(8);
		bonusRewardsY.add(10);

		gameThread = new Thread(this);
		gameThread.start();

		// add starting entities
		//puddles
		puddles.add(new Puddles(13, 1, this, tileM, rewardsValue));
		puddles.add(new Puddles(14, 13, this, tileM, rewardsValue));
		puddles.add(new Puddles(3, 11, this, tileM, rewardsValue));

		//rewards
		rewards.add(new Rewards(3, 2, this, tileM, rewardsValue));
		rewards.add(new Rewards(5, 3, this, tileM, rewardsValue));
		rewards.add(new Rewards(12, 1, this, tileM, rewardsValue));
		rewards.add(new Rewards(3, 10, this, tileM, rewardsValue));
		rewards.add(new Rewards(13, 13, this, tileM, rewardsValue));
		rewards.add(new Rewards(10, 10, this, tileM, rewardsValue));
		rewards.add(new Rewards(15, 6, this, tileM, rewardsValue));
		rewards.add(new Rewards(10, 4, this, tileM, rewardsValue));

		Enemies.add(new EnemyStaticPath(7,12 , this, tileM, boardM, player));
		Enemies.add(new EnemyStaticPath(13,11 , this, tileM, boardM, player));

		Enemies.add(new EnemyTracking(10,4 , this, tileM, boardM, player));
		Enemies.add(new EnemyTracking(14,8 , this, tileM, boardM, player));
	}

	private void BonusManager(){
		int check = (int) (Math.random()*50);
		if(check == 1 && bonusRewards.size()<2){
			int location = (int) (Math.random()*5);
			bonusRewards.add(new BonusReward(bonusRewardsX.get(location), bonusRewardsY.get(location), this, tileM, (int)(rewardsValue*2.5), 100));
		}

	}

	public void checkGameOver() {
		if (this.score < 0) {
			this.gameOver = true;
		}
		
		if ((this.rewards.size()== 0) && (player.x == 18 && player.y == 7)) {
			this.gameOver = true;
			this.win = true;
		}
	}

	/**
	 * The main game loop.
	 * 
	 * Loops at the desired frame rate and calls all updates needed.
	 */
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; // one second (1 billion nanoseconds)/FPS
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			if(start) {
				//update: information such as character positions
				update();
				
				//draw: draw the screen with the updated information
				repaint(); //java's way of calling paintComponent
				}
			
			else {
				repaint();

				if(keyH.enterPressed)
					start = true;
			}
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000; //convert to milliseconds
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval; //0.16667 seconds later
				
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * Calls all individual entities where updates are needed.
	 */
	public void update() {

		player.update();

		// enemies
		for (int i = 0; i < Enemies.size(); i++){
			Enemies temp = Enemies.get(i);
			temp.update();
		}

		//Bonus Rewards
		for(int i=0; i < bonusRewards.size(); i++){
			BonusReward temp = bonusRewards.get(i);
			temp.decreaseLife(i);
		}
			

		// glows
		for(int i=0; i<glows.size(); i++){
			Glow temp = glows.get(i);
			temp.update();
		}
			

		BonusManager();

		checkGameOver();

	}
	
	/**
	 * Re-draws the screen
	 */
	public void paintComponent(Graphics g) { //Graphics type is like your pencil
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g; // converts to this class

		if (start) {
			// background
			tileM.draw(g2);

			// puddles
			for(int i=0; i < puddles.size(); i++) { 
				Puddles tempPuddles = puddles.get(i);
				tempPuddles.draw(g2);
			}
		
			// rewards
			for(int i=0; i < rewards.size(); i++) { 
				Rewards tempRewards = rewards.get(i);
				tempRewards.draw(g2);
			}
			
			//Bonus Rewards
			for(int i=0; i < bonusRewards.size(); i++) {
				BonusReward tempBonusReward = bonusRewards.get(i);
				tempBonusReward.draw(g2);
			}

			// glows
			for(int i=0; i<glows.size(); i++) {
				Glow tempGlow = glows.get(i);
				tempGlow.draw(g2);
			}

			// Enemies
			for(int i=0; i < Enemies.size(); i++) {
				Enemies tempEnemies = Enemies.get(i);
				tempEnemies.draw(g2);
			}
				
			// player
			player.draw(g2);
			
			// UI
			ui.draw(g2);
		}
		
		else
			ui.drawTitleScreen(g2);

		
		g2.dispose(); // dispose this graphics content and release any system resources to save memory
	}
    
}
