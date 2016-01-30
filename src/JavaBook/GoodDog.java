package JavaBook;

public class GoodDog {
	
	private int size;
	private String name;
	
	public int getSize(){
		return size;
	}
	public void setSize(int s){
		size=s;
	}
	void bark()
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

}
