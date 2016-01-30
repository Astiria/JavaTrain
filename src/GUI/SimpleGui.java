package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.*;

import javax.swing.*;

public class SimpleGui {

	JFrame frame;
	JLabel label;

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton colorButton = new JButton("Change colors");
		colorButton.addActionListener(new ColorListener());
		colorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		JButton labelButton = new JButton("Change label");
		labelButton.addActionListener(new LabelListener());
		labelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		label = new JLabel("Label");
		DrawPanel drawPanel = new DrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);

		frame.setSize(500, 500);
		frame.setVisible(true);

	}
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

	

}
