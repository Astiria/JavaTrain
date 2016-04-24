package MusicPlayer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PlayerGui {
	
	private JPanel mainPanel;
	public ArrayList<JCheckBox> checkBoxList;
	private JFrame theFrame;
	MusicPlayer player;

	private String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Share",
			"Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conda",
			"Combell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conda"};
	
	public void buildGUI(){
		theFrame = new JFrame("My Player");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		player = new MusicPlayer();
		
		checkBoxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		
		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		JButton serializ = new JButton("Serializeit");
		serializ.addActionListener(new MySerializListener());
		buttonBox.add(serializ);
		
		JButton restore = new JButton("Restore");
		restore.addActionListener(new MyRestoreListener());
		buttonBox.add(restore);
		
		JButton clean = new JButton("Clean");
		clean.addActionListener(new MyCleanListener());
		buttonBox.add(clean);
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0; i<16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(buttonBox, BorderLayout.EAST);
		background.add(nameBox, BorderLayout.WEST);
		
		theFrame.getContentPane().add(background);
		
		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(mainPanel, BorderLayout.CENTER);
		
		for(int i = 0; i<256; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkBoxList.add(c);
			mainPanel.add(c);
		}
		player.setUpMidi();
		
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
	}
	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			player.buildTrackAndStart(PlayerGui.this);
		}
	}
	
	public class MyStopListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			player.sequencer.stop();
		}
	}
	
	public class MyUpTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = player.sequencer.getTempoFactor();
			player.sequencer.setTempoFactor((float)(tempoFactor*1.03));
		}
	}
	
	public class MyDownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = player.sequencer.getTempoFactor();
			player.sequencer.setTempoFactor((float)(tempoFactor*0.97));
		}
	}
	public class MySerializListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			
			boolean[] checkboxState = new boolean[256];
			
			for(int i = 0; i<256;i++){
				JCheckBox check = (JCheckBox) checkBoxList.get(i);
				if(check.isSelected()){
					checkboxState[i] = true;
				}
			}
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				try {
			
				FileOutputStream fileStream = new FileOutputStream(fc.getSelectedFile());
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
				os.writeObject(checkboxState);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		}
	}
	public class MyRestoreListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			boolean[] checkboxState = null;
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				try {
					
					FileInputStream fileIn = new FileInputStream(fc.getSelectedFile());
					ObjectInputStream is = new ObjectInputStream(fileIn);
					checkboxState = (boolean[]) is.readObject();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for(int i = 0; i<256;i++){
				JCheckBox check = (JCheckBox) checkBoxList.get(i);
				if(checkboxState[i]){
					check.setSelected(true);
				}
				else{
					check.setSelected(false);
				}
			}
		}
	}
	public class MyCleanListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
				for(int i = 0; i<256; i++){
				JCheckBox check = (JCheckBox) checkBoxList.get(i);
				check.setSelected(false);
			}
		}
	}
}
