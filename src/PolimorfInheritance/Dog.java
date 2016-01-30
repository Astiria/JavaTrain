package PolimorfInheritance;

public class Dog extends Canine implements IPet{
	
	private String name;
	
	public Dog(){
		System.out.println("Sozd Dog");
	}
	
	public Dog (String name) {
		this.name=name;
	}
	
	
	public void beFriendly(){
		System.out.println("I love you Dog");
	}
	public void play(){
		System.out.println("Dog play with me Dog");
	}
	
	public void eat(){
		System.out.println("Dog est korm Dog");
	}
	void makeNoise(){
		System.out.println("Dog Gaw Dog");
	}
	
	private void giveStick(){
		System.out.println("Give mi a stick " + name);
	}

	public void sleep(){
		super.sleep();
		System.out.println("Spit kak sobaka (Sleep as Dog) Dog");
	}

}
