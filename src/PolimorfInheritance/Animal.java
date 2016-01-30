package PolimorfInheritance;

import java.util.ArrayList;

public abstract class Animal extends Object{

	String picture;
	String food;
	int hunger;
	int [] bourdares;
	double [] location;
	
	public Animal(){
		System.out.println("Sozd Animal");
	}
	void makeNoise(){
		System.out.println("Goworit czto-to Animal");
	}
	public void eat(){
		System.out.println("Est czto-to Animal");
	}
	public void sleep(){
		System.out.println("Spit kak-to Animal");
	}
	void roam(){
		System.out.println("Slaetsa gde-to Animal");
	}
	
}
