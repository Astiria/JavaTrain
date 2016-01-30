package GUI;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
	int x = 70;
	int y = 70;
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InnerDrawPanel panel = new InnerDrawPanel();
		
		frame.getContentPane().add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		for(int i =0; i<300;i++){
			x++;
			y++;
			panel.repaint();
			
			try{
				Thread.sleep(50);
			} catch(Exception ex){}
		}
	}
	
	class InnerDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.WHITE);
			//заполнить белым цветом с начала - координаты 0 0
			//по всей ширине и высоте панели
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 40, 40);
		}
	}

}
