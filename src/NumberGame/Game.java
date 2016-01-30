package NumberGame;

public class Game {
	
	
	public void startGame()
	{
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		
		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
		
		boolean p1IsRight = false;
		boolean p2IsRight = false;
		boolean p3IsRight = false;
		
		int targetNumber = (int)(Math.random()*10);
		System.out.println("Cyfra ot 0 do 9");
		
		while(true){
			System.out.println("Nugno ugadat cyfru: " + targetNumber);
			p1.guess();
			p2.guess();
			p3.guess();
			
			guessp1 = p1.number;
			System.out.println("Perwyj igrok: "+guessp1);
			guessp2 = p2.number;
			System.out.println("Wtoroj igrok: "+guessp2);
			guessp3 = p3.number;
			System.out.println("Tretij igrok: "+guessp3);
			
			if(guessp1==targetNumber){
				p1IsRight=true;
			}
			if(guessp2==targetNumber){
				p2IsRight=true;
			}
			if(guessp3==targetNumber){
				p3IsRight=true;
			}
			
			if(p1IsRight||p2IsRight||p3IsRight){
				System.out.println("U nas est pobeditel!");
				System.out.println("Perwyj igrok ugadal? " + p1IsRight);
				System.out.println("Wtoroj igrok ugadal? " + p2IsRight);
				System.out.println("tretij igrok ugadal? " + p3IsRight);
				System.out.println("Koniec igry");
				break;
			}
			else{
				System.out.println("Poprobovat ewe raz");
			}
			
				
			
		}
		
		
	}
	

}
