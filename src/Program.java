import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		/*Power pow = new Power();
		System.out.println("Wed x: ");
		Scanner kl = new Scanner(System.in);
		int x = kl.nextInt();
		System.out.println("Wed stepen: ");
		int y = kl.nextInt();
		
		System.out.println("rezult: " + pow.power(x, y));*/
		String s = String.format("%,d", 1000000000);
		String d = String.format("Mne %,.2f oshybki", 4765.09654);
		String dataFull = String.format("%tc", new Date());
		String dataTime = String.format("%tr", new Date());
		Date today = new Date();
		String today1 = String.format("%ta %<tb %<td", today);
		System.out.println(today1);
		System.out.println(dataFull);
		System.out.println(dataTime);
		
		Calendar c = Calendar.getInstance();
		c.set(2004, 0,7,15,40);
		long day1 = c.getTimeInMillis();
		day1 += 1000*60*60;
		c.setTimeInMillis(day1);
		System.out.println("Novyj czas "+c.get(c.HOUR_OF_DAY));
		c.add(c.DATE, 35);
		System.out.println("Dobavit 35 dniej "+c.getTime());
		c.roll(c.DATE, 35);
		System.out.println("Prokrutit 35 dniej "+c.getTime());
		c.set(c.DATE, 1);
		System.out.println("Ystanovit datu v 1 "+c.getTime());
			
		
	}
	
	

}
