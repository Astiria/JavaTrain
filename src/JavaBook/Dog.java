package JavaBook;

public class Dog {
	int size;
	String name;
	String breed;
	
	public Dog(String dogName, int dogSize)
	{
		this.name = dogName;
		this.size = dogSize;
	}
	
	void bark1()
	{
		if(size>60){
			System.out.println(name+" gav");
		}
		else if(size>14){
			System.out.println(name+ " vuf");
		}
		else{
			System.out.println(name+ " tiaf");
		}
	}
	
/*	void bark()
	{
		System.out.println(name + " gav");
	}
	void eat()
	{
		System.out.println("em");
	}
	void chaseCat()
	{
		System.out.println("kot tam");
	}
*/
}
