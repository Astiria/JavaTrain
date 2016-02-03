package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Components implements ActionListener, ItemListener, ListSelectionListener{
	
	String [] listEntries = {"one", "two", "cat", "dog" , "mama"};
	JTextArea text;
	JCheckBox check;
	JList<String> list;
	
	public void playWithKomponents(){
		
		JFrame fr = new JFrame("New komponents");
		JPanel pn = new JPanel();
		JButton but = new JButton("Click me!");
		list = new JList<>(listEntries);
		
		JScrollPane sk = new JScrollPane(list);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		sk.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sk.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		check = new JCheckBox("Goes to 11");
		check.addItemListener(this);
		check.setSelected(true);
		
		but.addActionListener(this);
		
		JLabel label = new JLabel();
		label.setText("First name: ");
		JTextField firstName = new JTextField(20);
		firstName.setText("your name \n");
				
		text = new JTextArea(10,20);
		JScrollPane scroller = new JScrollPane(text);
		text.setText(firstName.getText());
		text.setLineWrap(true);
		text.requestFocus();
		
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		pn.add(label);
		pn.add(firstName);
		pn.add(scroller);
		pn.add(check);
		pn.add(sk);
		
		fr.getContentPane().add(pn, BorderLayout.CENTER);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.getContentPane().add(but, BorderLayout.SOUTH);
		fr.setSize(500, 500);
		fr.setVisible(true);
				
	}
	
	public void valueChanged(ListSelectionEvent lse){
		if(!lse.getValueIsAdjusting()){
			String selection = (String) list.getSelectedValue();
			System.out.println(selection);		
		}
		
	}
	public void itemStateChanged(ItemEvent iev){
		String onOrOff = "off";
		if(check.isSelected()) {
			onOrOff = "on";
		}
		System.out.println(onOrOff);
	}
	
	public void actionPerformed(ActionEvent aev){
		text.append("button clicked \n ");
	}
	
}
