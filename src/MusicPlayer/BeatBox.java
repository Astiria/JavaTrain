package MusicPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.util.*;

public class BeatBox {
		
	Sequencer sequencer;
	Sequence sequence;
	Track track;
		
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
	
	public void buildTrackAndStart(){
		int[] trackList = null;
		 sequence.deleteTrack(track);
		 track = sequence.createTrack();
		 
		 for(int i = 0; i<16; i++){
			 trackList = new int[16];
			 
			 int key = instruments[i];
			 
			 for(int j = 0; j<16; j++){
				 JCheckBox jc = (JCheckBox) checkBoxList.get(j+(16*i));
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
	}
	
	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			buildTrackAndStart();
		}
	}
	
	public class MyStopListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			sequencer.stop();
		}
	}
	
	public class MyUpTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*1.03));
		}
	}
	
	public class MyDownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*0.97));
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
