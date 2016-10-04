import java.util.ArrayList;

public class Grid {
	
	private int scale;
	private char [][] dotsDisplay;
	private int [] [] unplayableSpaces;
	private ArrayList<Territory> unclaimedTerritories;
	private ArrayList<Territory> claimedTerritories;
	
	public Grid() {
		unclaimedTerritories = new ArrayList<Territory>();
		claimedTerritories = new ArrayList<Territory>();
	}
	
	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return scale;
	}

	public void initDotsDisplay(int scale) {

		char [] [] dotsDisplay = new char [scale][scale];

		for (int a = scale - 1; a >= 0; a --)
			for (int b = 0; b < scale; b ++)
				dotsDisplay [b][a] = ' ';

		this.dotsDisplay = dotsDisplay;
	}

	public char [] [] getDotsDisplay() {
		return dotsDisplay;
	}
	
	public void initUnplayableSpaces(int scale) {

		int [] [] unplayableSpaces = new int [scale][scale];

		for (int a = scale - 1; a >= 0; a --)
			for (int b = 0; b < scale; b ++)
				unplayableSpaces [b][a] = 0;

		this.unplayableSpaces = unplayableSpaces;
	}
	
	public void addUnplayableSpace(int posX, int posY) {
		unplayableSpaces [posX][posY] = 1;
	}

	public int [] [] getUnplayableSpaces() {
		return unplayableSpaces;
	}
	
	public void addUnclaimedTerritory(Territory territory) {
		unclaimedTerritories.add(territory);
	}
	
	public void removeUnclaimedTerritory(Territory territory) {
		unclaimedTerritories.remove(territory);
	}
	
	public ArrayList<Territory> getUnclaimedTerritories() {
		return unclaimedTerritories;
	}
	
	public void addclaimedTerritory(Territory territory) {
		claimedTerritories.add(territory);
	}
	
	public ArrayList<Territory> getClaimedTerritories() {
		return claimedTerritories;
	}
}
