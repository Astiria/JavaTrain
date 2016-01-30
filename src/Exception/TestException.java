package Exception;

public class TestException {

	public static void main(String[] args) {
		//String test = "yes";
		String test = "net";
		try{
			System.out.println("naczalo try");
			doRisky(test);
			System.out.println("koniec try");
		}catch (ScaryException se){
			System.out.println("krach");
		} finally {
			System.out.println("finally");
		}
		System.out.println("koniec main");
	}
	
	static void doRisky(String test) throws ScaryException{
		System.out.println("naczalo opasnogo metoda");
		if("yes".equals(test)){
			throw new ScaryException();
		}
		System.out.println("koniec metoda");
		return;
	}

}
