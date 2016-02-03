package GUI;

import java.awt.*;
import javax.swing.*;


public class DrawPanel extends JPanel{
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
	
		g.setColor(Color.black);
		g.fillRect(20, 50, 100, 100);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		/*Image image = new ImageIcon("E:/ideal_girl.png").getImage(); 
		g.drawImage(image, 3, 4, this);*/
		
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		
		/*GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);*/
		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		g.fillOval(70, 70, 100, 100);
	}

}
