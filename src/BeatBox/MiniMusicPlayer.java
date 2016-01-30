package BeatBox;

import javax.sound.midi.*;

public class MiniMusicPlayer {
	
	public void play(){
				 
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			Track track = sequence.createTrack();
			
			for(int i = 5; i<61; i++){
				//i - nota
				track.add(MiniMusicCmdLine.makeEvent(144, 1, i, 100, i));
				track.add(MiniMusicCmdLine.makeEvent(128, 1, i, 100, i+2));
			}
			//zapusk proigrywania
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
