package MusicPlayer;

import javax.sound.midi.*;
import javax.swing.*;

public class EventMaker {
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
		ShortMessage a = new ShortMessage();
		a.setMessage(comd, chan, one, two);
		event = new MidiEvent(a, tick);
		}catch (Exception e){}	
		
		return event;
	}
	

}