import javax.swing.*;
import java.awt.*;

public class Galaga extends JFrame{

   public static void main(String args[]) {

   JFrame window = new JFrame("Galaga");
   window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   window.setResizable(false);
   
   GamePanel gamePanel = new GamePanel();
   window.setContentPane(gamePanel);
   window.pack();
   
   window.setLocationRelativeTo(null);
   window.setVisible(true);
   
   gamePanel.startGameThread();
   
   }
}