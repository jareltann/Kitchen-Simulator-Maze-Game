package cmpt276Game.main;

import javax.swing.JFrame;

public class App 
{
    public static void main( String[] args )
    {
        JFrame window = new JFrame(); //creates frame for the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the JFrame closes when user closes the window
        window.setResizable(false); //the window is not allowed to be resized 
        window.setTitle("Kitchen Simulator"); //title displayed on the window
        
        GamePanel gamePanel = new GamePanel(); //instantiate the GamePanel from GamePanel class
        window.add(gamePanel); //add the GamePanel to the JFrame window
        
        window.pack(); //automatically sizes the JFrame to fit its components
        
        window.setLocationRelativeTo(null); //Centers the JFrame window on the screen
        window.setVisible(true); //Makes the JFrame window visible

        gamePanel.startGameThread(); //starts the game thread, which runs the game logic and graphics
    }
}
