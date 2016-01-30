package PolimorfInheritance;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		ArrayList<Animal> zoo = new ArrayList<Animal>();

		zoo.add(new Dog());
		zoo.add(new Cat());
		zoo.add(new Tiger());
		zoo.add(new Hippo());
		
		for(int i = 0; i<zoo.size(); i++)
		{
			zoo.get(i).eat();		
		}
		
				
		/*PetOwner p = new PetOwner();
		p.start();
		
		Dog a = new Dog("Lana");*/
		
		Dog d = new Dog();
		d.sleep();
				
		/*MyDogList l = new MyDogList();
		l.add(a);
		Cat c = new Cat();*/
		
		/*if (a.equals(c)){System.out.println("true");}
		else {System.out.println("false");}
		
		System.out.println(c.getClass()+" "+ c.hashCode()+" "+ c.toString());*/
		//Приведение типов		
		/*Object o = new Dog();
		Dog dog = (Dog) o;
		dog.beFriendly();*/
		
	}

}
