package MusicPlayer;

import javax.sound.midi.*;
import javax.swing.*;

public class MusicPlayer {
	public Sequencer sequencer;
	private Sequence sequence;
	private Track track;
	
		
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
		
	public void setUpMidi(){
		
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildTrackAndStart(PlayerGui gui){
		int[] trackList = null;
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		 
		 for(int i = 0; i < 16; i++){
			 trackList = new int[16];
			 
			 int key = instruments[i];
			 
			 for(int j = 0; j < 16; j++){
				 JCheckBox jc = (JCheckBox) gui.checkBoxList.get(j+(16*i));
				 if(jc.isSelected()){
					 trackList[j] = key;
				 } 
				 else {
					 trackList[j] = 0;
				 }
			 }
			 makeTracks(trackList);
			 track.add(EventMaker.makeEvent(176,1,127,0,16));
		 }
		 track.add(EventMaker.makeEvent(192, 9, 1, 0, 15));
		 try{
			 sequencer.setSequence(sequence);
			 sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			 sequencer.start();
			 sequencer.setTempoInBPM(120);
		 } catch (Exception e){
			 e.printStackTrace();
		 }
	}
	
	
	
	public void makeTracks(int[] list){
		for(int i = 0; i<16; i++){
			int key = list[i];
			
			if(key!=0){
				track.add(EventMaker.makeEvent(144, 9, key, 100, i));
				track.add(EventMaker.makeEvent(128, 9, key, 100, i+1));
			}
		}
	}

}
