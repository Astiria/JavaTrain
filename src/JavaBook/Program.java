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
	String word = "бутылок(бутылки)";
	while (beerNum >0)
	{
		if(beerNum==1)
		{
			word = "бутылка";
		}
		System.out.println(beerNum + " " + word + " пива на стене");
		System.out.println(beerNum + " " + word + " пива.");
		System.out.println("Возьми одну.");
		System.out.println("Пусти по кругу.");
		beerNum -=1;
		if(beerNum>=1)
		{
			System.out.println(beerNum + " " + word + " пива на стене");
		}
		else
		{
			System.out.println("Нет бутылок пива на стене");
		}
	}
	}
	
	public static void genericPhrase(){
		String[] wordList1 = {"круглосуточный", "трехзвенный","взаимный",
				"обоюдный", "проникающий","динамичный","умный"};
		String[] wordList2 = {"уполномоченный","трудный", "чистый продукт",
				"сетевой","общий","совместный"};
		String[] wordList3 = {"процесс","пункт разгрузки","тип структуры",
				"обзор","портал","талант","подход"};
		
		int oneLenght = wordList1.length;
		int twoLenght = wordList2.length;
		int threeLenght = wordList3.length;
		
		int rand1 = (int) (Math.random()*oneLenght);
		int rand2 = (int) (Math.random()*twoLenght);
		int rand3 = (int) (Math.random()*threeLenght);
		
		String phrase = wordList1[rand1]+" "+wordList2[rand2]+" "+
		wordList3[rand3];
		
		System.out.println("Все что нам нужно - это "+phrase);
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
