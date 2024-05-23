import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
public class BaseObject extends JPanel
{
   public static BufferedImage image;
   private int x;
   private int y;
   
   public BaseObject(int posX, int posY, String img)
   {
      super();
      
      x = posX;
      y = posY;
      try
      {
         image = ImageIO.read(new File(img));
      }
      catch (IOException e)
      {
         System.out.println("couldnt' read imaeg");
      }
      
   }
   public void paintComponent(Graphics g, int width, int height)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(image, x, y, width, height, null);

   }
   
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
}