package SeaBatle;

import java.util.*;

public class DotComBust {

	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	int numOfGuesses = 0;

	public void setUpGame() {
		DotCom site1 = new DotCom();
		site1.setSiteName("Pets.com");
		DotCom site2 = new DotCom();
		site2.setSiteName("Toys.com");
		DotCom site3 = new DotCom();
		site3.setSiteName("Go.com");
		dotComList.add(site1);
		dotComList.add(site2);
		dotComList.add(site3);

		System.out.println("Cel potopit 3 sajta Pets.com, Toys.com, Go.com" + " za min k-wo hodow");
		for (DotCom dotComToSet : dotComList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}

	public void startPlaying() {
		while (!dotComList.isEmpty()) {
			String userGuess = helper.getUserInput("Sdelajte hod");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "Mimo";

		for (DotCom dotComToTest : dotComList) {
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("Popal")) {
				break;
			}
			if (result.equals("Potopil")) {
				dotComList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}

	private void finishGame() {
		System.out.println("Vse sajty potopleny");
		if (numOfGuesses <= 18) {
			System.out.println("Popytok " + numOfGuesses + " good");
		} else {
			System.out.println("Popytok " + numOfGuesses + " luzer");
		}
	}

}
