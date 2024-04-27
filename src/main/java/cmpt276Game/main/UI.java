package cmpt276Game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

/**
* Displays images on the GamePanel depending on the state of the game
*/
public class UI {

	GamePanel gp;
	Font arial_40, arial_120B, arial_30;
	//public boolean gameFinished = false;
	
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("0.00");
	
	int offset;
	Graphics2D g2;
	
	
	/**
	* Constructor of UI class
	* @param gp of type GamePanel that gets the gamepanel to display its interface on
	*/
	public UI(GamePanel gp) {
		this.gp = gp;
		this.offset = 0;
		
		arial_40 = new Font("Arial",Font.PLAIN,40);
		arial_120B = new Font("Arial",Font.BOLD,120);
		arial_30 = new Font("Arial",Font.PLAIN,30);

	}
	

	 /**
     * Displays the title screen after opening the game
     * @param g2 used to create the image to display the title screen
     * Title screen disappears and goes into game state after user hits enter
     */
	public void drawTitleScreen(Graphics2D g2) {
		
		g2.setColor(new Color(0,0,0));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		//Title Name
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
		String text = "Kitchen Simulator";
		int x = 60;
		int y = gp.tileSize*4;
		
		//Shadow
		g2.setColor(Color.gray);
		g2.drawString(text, x+5, y+5);
		
		//main colour
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//Menu
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
		
		text = "NEW GAME (PRESS ENTER)";
		x = 200;
		y = gp.tileSize*10;
		g2.drawString(text, x, y);
		
		
	}
	
	
	private void endGameDisplay(Graphics2D g2) {

		String text;
		int textLength;
		int x, y;
		
		if (gp.win) {
			text = "You Win!";
			g2.setColor(Color.green);
		}
		else {
			text = "Game Over";
			g2.setColor(Color.red);
		}
		
		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		x = gp.screenWidth/2 - textLength/2;
		y = gp.screenHeight/2 - (gp.tileSize*3);

		g2.drawString(text, x, y);


		g2.setFont(arial_40);
	}
	
	private void winScreen(Graphics2D g2) {
		String text;
		int textLength;
		int x, y;
		text = "Your score is: " + gp.score;
		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		x = gp.screenWidth/2 - textLength/2;
		y = (gp.screenHeight/2 + (gp.tileSize*4))+ 50;
		g2.drawString(text, x, y);

		text = "Your time is: " + dFormat.format(playTime) + " seconds!";
		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		x = gp.screenWidth/2 - textLength/2;
		y = (gp.screenHeight/2 + (gp.tileSize*4))-5;
		g2.drawString(text, x, y);
	}
	
	
	 /**
     * Displays the image of the game state and after the game
     * @param g2 used to create the different images
     * Game state changes to a pop up screen after game is over
     * Displays the score and time throughout the game
     * Displays the total score and time taken to complete the game if the player wins
     */
	public void draw(Graphics2D g2) {

			if (gp.gameOver == true) {

				g2.setColor(new Color(0,0,0,150));
				g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
				
				g2.setFont(arial_120B);

				
				endGameDisplay(g2);
				
				if (gp.win) {

					winScreen(g2);
					
				}

				gp.gameThread = null;

			}

			else {

				g2.setFont(arial_30);
				g2.setColor(Color.white);
				g2.drawString("Score = " + gp.score, 50, 35);

				//Time
				playTime += (double)1/10;
				String playTimeFormatted = new DecimalFormat("#.##").format(playTime);
				if(playTimeFormatted.length() >= 5)
					offset = 80;
				else if (playTimeFormatted.length() >= 4)
					offset = 40;

				g2.drawString("Time (Seconds): " + playTimeFormatted , (gp.tileSize*17) - (200 + offset), 35);
		}



		}
	}
	

