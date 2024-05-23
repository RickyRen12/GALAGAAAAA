import javax.swing.*;
import java.awt.*;

public class Enemy extends Entity {
GamePanel gamePanel;
PlayerInput playerInput;

   public Enemy (GamePanel x, PlayerInput y) {
      gamePanel = x;
      playerInput = y;
      setDefaultValues();
   }
   public void setDefaultValues() {
      x = 100;
      y = 600;
      speed = 4;
   }
   public void update() {
    if (playerInput.upPressed == true) {
         y = y - speed;
      }
      if (playerInput.downPressed == true) {
         y = y + speed;
      }
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
   }



}
