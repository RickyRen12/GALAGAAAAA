import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
final int originalTileSize = 16; // 16x16 Tile
final int scale = 4; //Scaled Up Screen For Modern Computers
public final int tileSize = originalTileSize * scale; // 48 * 48 Tile

final int maxScreenCol = 12; // Amount of Tiles for Screen Width
final int maxScreenRow = 16; // Amount of Tiles for Screen Height
final int screenWidth = tileSize * maxScreenCol; // 768 Pixels Wide
final int screenHeight = tileSize * maxScreenRow; // 1024 Pixels High

Thread gameThread;
PlayerInput playerInput = new PlayerInput(); // Key Inputs From PlayerInput Class 
Player player = new Player(this, playerInput);
Aliens bob = new Aliens(0, 0, "G:\\My Drive\\Galaga\\Images\\bruh.png");

// Sets Player Position and Speed
int playerX = 100;
int playerY = 100;
int playerSpeed = 4;
int fps = 60; // Frames Per Second Limiting Speed Of Player/Enemy

   public GamePanel() { //Creates Game Panel and Sets Background Color to Black
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.black); 
      this.addKeyListener(playerInput);
      this.setFocusable(true);
   }
   public void startGameThread() { //Starts Game Timer (Helps with Game Animations)
      gameThread = new Thread(this);   
      gameThread.start();
   }
   @Override
   public void run() { // Method to Run the Game
   double drawInterval = 1000000000/fps; // 0.016667 seconds per frame
   double nextDrawTime = System.nanoTime() + drawInterval;
      while(gameThread != null) {
         // IN THIS LOOP IT WILL UPDATE THE POSITIONS OF PLAYERS AND ENEMIES
         long currentTime = System.nanoTime(); 
         update(); // Updates Position
         repaint(); // Replaces Player in New Position
         try {
            double remainingTime = nextDrawTime - System.nanoTime(); 
            remainingTime = remainingTime/1000000; //converts nano seconds to milliseconds
            if (remainingTime < 0) {
               remainingTime = 0;
            }
            Thread.sleep((long)remainingTime);
            nextDrawTime += drawInterval;
         } 
         catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   public void update() {
      player.update();
   }
   public void paintComponent(Graphics x) {
      super.paintComponent(x);
      Graphics2D x2 = (Graphics2D)x;
      player.draw(x2);
      x2.dispose();
   }

}
      
