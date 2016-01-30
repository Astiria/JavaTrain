package PolimorfInheritance;

public class Cat extends Feline implements IPet{
	
	
	public void play() {}
	
	public void eat(){
		System.out.println("Cot est korm Cat");
	}
	void makeNoise(){
		System.out.println("Cot Miau Cat");
	}
	
	public void beFriendly() {
				
	}

}
