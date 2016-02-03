package GUI;

import java.awt.*;
import javax.swing.*;

public class FlowLay {
	
	public void drawPanel(){
		
		JFrame fr = new JFrame("Panel");
		JPanel pan = new JPanel();
		JButton but = new JButton("Jaja");		
		JButton but1 = new JButton("very big button");
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		
		pan.setBackground(Color.CYAN);
		pan.add(but);
		pan.add(but1);
			
		fr.getContentPane().add(pan, BorderLayout.EAST);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(300, 300);
		fr.setVisible(true);
		
	}

}
