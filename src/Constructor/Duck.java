package Constructor;

public class Duck {
	int size;
	
	public Duck(){}
	
	public Duck(int duckSize)
	{
		size=duckSize;
		System.out.println("Kria " + "razmer " + size);
	}
	
	public void setSize(int newSize)
	{
		size = newSize;
	}

}
