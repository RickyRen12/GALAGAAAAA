import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
GamePanel gamePanel;
PlayerInput playerInput;

   public Player (GamePanel x, PlayerInput y) {
      gamePanel = x;
      playerInput = y;
      setDefaultValues();
      getPlayerImage();
   }
   public void setDefaultValues() {
      x = 100;
      y = 850;
      speed = 6;
   }
   public void getPlayerImage() {
      try {
         starship = ImageIO.read(getClass().getResourceAsStream("Users/1598832/Downloads/starship.png"));
      }
      catch(IOException e) {
         System.out.println("not projecting");
         e.printStackTrace();
      }
   }
   public void update() {
      if (playerInput.rightPressed == true) {
         x = x + speed;
      }
      if (playerInput.leftPressed == true) {
         x = x - speed;
      }
   }
   public void draw(Graphics2D g) {
      g.setColor(Color.white);
      g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
     // g.drawImage(starship, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
   }



}
