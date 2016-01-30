package MusicPlayer;

import java.awt.*;
import javax.sound.midi.*;
import javax.swing.*;


public class MusicPlayer {
	static JFrame f = new JFrame("My clip");
	static DrawPanel ml;
	
	public void setUpGui(){
		ml = new DrawPanel();
		f.setContentPane(ml);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
	}
	
	public void go(){
		setUpGui();
		
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(ml, new int[]{127});
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i =0;i<60;i+=4){
				r=(int)((Math.random()*50)+1);
				track.add(EventMaker.makeEvent(144, 1, r, 100, i));
				track.add(EventMaker.makeEvent(176, 1, 127, 0, i));
				track.add(EventMaker.makeEvent(128, 1, r, 100, i+2));
			}
			sequencer.setSequence(seq);
			sequencer.start();
			sequencer.setTempoInBPM(120);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public class DrawPanel extends JPanel implements ControllerEventListener{
		boolean msg = false;
		
		public void controlChange(ShortMessage event){
			msg = true;
			repaint();
		}
		
		public void paintComponent(Graphics g){
			if(msg){
				Graphics2D g2 = (Graphics2D) g;
				
				int red = (int)(Math.random()*255);
				int green = (int)(Math.random()*255);
				int blue = (int)(Math.random()*255);
				
				g.setColor(new Color(red, green, blue));
				
				//Generic accidental color and paint rectangle
				int height = (int)((Math.random()*120)+10);
				int width = (int)((Math.random()*120)+10);
				int x = (int)((Math.random()*40)+10);
				int y = (int)((Math.random()*40)+10);
				g.fillRect(x, y, height, width);
				msg = false;
			}
		}
		

	}

}
