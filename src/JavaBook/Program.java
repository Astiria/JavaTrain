package JavaBook;



public class Program {

	public static void main(String[] args) {
		
//		 beerBoutle();
//		 genericPhrase();
//		 kodMagnes();
//		 dogsMetods();
		
		Dog dog1 = new Dog("Fido", 61);
		Dog dog2 = new Dog("Fred", 18);
		Dog dog3 = new Dog("Lina", 10);
		dog1.bark1();
		dog2.bark1();
		dog3.bark1();
		
	}
/*	
	public static void dogsMetods() {
		Dog dog1 = new Dog();
		dog1.name = "bark";

		Dog[] myDogs = new Dog[3];
		myDogs[0] = new Dog();
		myDogs[0].name = "fido";
		myDogs[1] = new Dog();
		myDogs[1].name = "fred";
		myDogs[2] = dog1;

		int x = 0;
		while (x < myDogs.length) {
			myDogs[x].bark();
			x = x + 1;
		}

	}

	public static void beerBoutle(){

	int beerNum = 99;
	String word = "�������(�������)";
	while (beerNum >0)
	{
		if(beerNum==1)
		{
			word = "�������";
		}
		System.out.println(beerNum + " " + word + " ���� �� �����");
		System.out.println(beerNum + " " + word + " ����.");
		System.out.println("������ ����.");
		System.out.println("����� �� �����.");
		beerNum -=1;
		if(beerNum>=1)
		{
			System.out.println(beerNum + " " + word + " ���� �� �����");
		}
		else
		{
			System.out.println("��� ������� ���� �� �����");
		}
	}
	}
	
	public static void genericPhrase(){
		String[] wordList1 = {"��������������", "�����������","��������",
				"��������", "�����������","����������","�����"};
		String[] wordList2 = {"��������������","�������", "������ �������",
				"�������","�����","����������"};
		String[] wordList3 = {"�������","����� ���������","��� ���������",
				"�����","������","������","������"};
		
		int oneLenght = wordList1.length;
		int twoLenght = wordList2.length;
		int threeLenght = wordList3.length;
		
		int rand1 = (int) (Math.random()*oneLenght);
		int rand2 = (int) (Math.random()*twoLenght);
		int rand3 = (int) (Math.random()*threeLenght);
		
		String phrase = wordList1[rand1]+" "+wordList2[rand2]+" "+
		wordList3[rand3];
		
		System.out.println("��� ��� ��� ����� - ��� "+phrase);
	}
	
	public static void kodMagnes(){
		int x=3;
		while(x>0){
			if (x>2){
				System.out.print("a");
			}
			x=x-1;
			System.out.print("-");
			if(x==1)
				{System.out.print("d");
				x=x-1;}
				if(x==2){
				System.out.print("b c");
			}
		
			
			}
	}
	
	*/
	
}
