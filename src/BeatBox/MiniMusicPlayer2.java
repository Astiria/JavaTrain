package BeatBox;

import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener{
	
	public void go(){
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(this, eventsIWant);
			
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			Track track = sequence.createTrack();
			
			for(int i = 5; i<60; i+=4){
				track.add(MiniMusicCmdLine.makeEvent(144, 1, i, 100, i));
				track.add(MiniMusicCmdLine.makeEvent(176, 1, 127, 0, i));
				track.add(MiniMusicCmdLine.makeEvent(128, 1, i, 100, i+2));
			}
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void controlChange(ShortMessage event) {
				
	}

}
