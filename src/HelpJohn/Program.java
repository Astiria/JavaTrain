package HelpJohn;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner kl = new Scanner(System.in);
		System.out.println("Wwed dlinu l = ");
		double l = kl.nextDouble();
		System.out.println("Wwed wyrinu w = ");
		double w = kl.nextDouble();
		System.out.println("Wwed vysotu h = ");
		double h = kl.nextDouble();
		
		EasyWallpaper wal = new EasyWallpaper();
		System.out.println(wal.wallpaper(l,w, h));
		//System.out.println(wal.wallpaper(4, 3.5, 3));
	}

}
