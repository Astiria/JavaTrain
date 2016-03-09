package MusicPlayer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.*;

import MusicPlayer.BeatBox.MyDownTempoListener;
import MusicPlayer.BeatBox.MyStartListener;
import MusicPlayer.BeatBox.MyStopListener;
import MusicPlayer.BeatBox.MyUpTempoListener;


public class PlayerGui {
	
	private JPanel mainPanel;
	private ArrayList<JCheckBox> checkBoxList;
	private JFrame theFrame;

	private String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Share",
			"Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conda",
			"Combell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conda"};
	
	public void buildGUI(){
		theFrame = new JFrame("My Player");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
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
		setUpMidi();
		
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
	}
}
