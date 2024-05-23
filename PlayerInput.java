import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInput implements KeyListener {
public boolean upPressed;
public boolean downPressed;
public boolean rightPressed;
public boolean leftPressed;

   @Override
   public void keyTyped(KeyEvent e) {
   
   }
   @Override
   public void keyPressed(KeyEvent e) {
   int x = e.getKeyCode();
      if (x == KeyEvent.VK_W) {
         upPressed = true;
      }
      if (x == KeyEvent.VK_A) {
         leftPressed = true;
      }
      if (x == KeyEvent.VK_S) {
         downPressed = true;
      }
      if (x == KeyEvent.VK_D) {
         rightPressed = true;
      }  
   }
   @Override
   public void keyReleased(KeyEvent e) {
   int x = e.getKeyCode();
      if (x == KeyEvent.VK_W) {
         upPressed = false;
      }
      if (x == KeyEvent.VK_A) {
         leftPressed = false;
      }
      if (x == KeyEvent.VK_S) {
         downPressed = false;
      }
      if (x == KeyEvent.VK_D) {
         rightPressed = false;
      }  
   }
}