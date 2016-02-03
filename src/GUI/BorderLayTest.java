package GUI;

import javax.swing.*;
import java.awt.*;

public class BorderLayTest {
	
	
	public void initializationButtons(){
		
		
		JFrame fr = new JFrame();
		
		JButton east = new JButton("East");
		JButton west = new JButton("West");
		JButton center = new JButton("Center");
		JButton north = new JButton("North");
		JButton south= new JButton("South");
		
	
		fr.getContentPane().add(north, BorderLayout.NORTH);
		fr.getContentPane().add(center, BorderLayout.CENTER);
		fr.getContentPane().add(west, BorderLayout.WEST);
		fr.getContentPane().add(east, BorderLayout.EAST);
		fr.getContentPane().add(south, BorderLayout.SOUTH);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fr.setSize(300, 300);
		fr.setVisible(true);
		
		
		
	}

}
