package PolimorfInheritance;

public class PetOwner {
	
	public void giveShot(Animal a) {
		a.makeNoise();		
	}
	public void start() {
		PetOwner v = new PetOwner();
		Dog d = new Dog();
		Hippo h = new Hippo();
		v.giveShot(d);
		v.giveShot(h);
		
	}

}
