package HelpJohn;

public class EasyWallpaper {
	
	
	
	
	public String wallpaper(double l, double w, double h) {
		 String[] names = new String[] {"", "one", "two", "three", "four",
	                "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
	                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
	                "nineteen", "twenty"};
		 double weightRulon = 0.52;
		 double lenghtRulon = 10;
		 double koef = 1.15;
		 if(l*w*h == 0){
			 return "zero";
		 }
		 
		 int rez = (int)Math.ceil(((2*h*(w+l)/(weightRulon*lenghtRulon))*koef));
		 return names[rez];
		 		
	  }
}
