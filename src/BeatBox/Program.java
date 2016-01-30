package BeatBox;

import java.util.Scanner;

public class Program {
	
	

	public static void main(String[] args) {
		/*MiniMusicPlayer player = new MiniMusicPlayer();
		player.play();*/
		MiniMusicPlayer2 player2 = new MiniMusicPlayer2();
		player2.go();
		}
	
	/*public void generateNote(){
		int[] arg = new int[2];
		Scanner kl = new Scanner(System.in);
		System.out.println("wwed instrument");
		int instrument = kl.nextInt();
		System.out.println("wwed notu");
		int note = kl.nextInt();
		arg[0] = instrument;
		arg[1] = note;
		
		MiniMusicCmdLine mini = new MiniMusicCmdLine();
		if(arg.length<2)
		{
			System.out.println("wwed noty");
		}
		else{
			
		mini.play(instrument, note);
		}
	}
*/
}
