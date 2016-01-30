package SeaBatle;

import java.util.ArrayList;

public class DotCom {

	private String siteName;
	private ArrayList<String> locationCells;

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
	}

	public String checkYourself(String userInput) {
		String result = "Mimo";
		int index = locationCells.indexOf(userInput);

		if (index >= 0) {
			locationCells.remove(index);

			if (locationCells.isEmpty()) {
				result = "Potopil";
				System.out.println("Wy potopili " + siteName);
			} else {
				result = "Popal";
			}
		}
		
		return result;
	}

}
