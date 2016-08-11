import java.util.*;
import java.io.*;

public class Grid {

	private int scale;
	private int [] scoreDisplay;
	private char [][] dotsDisplay;
	private ArrayList<Dots> dotsContainer;
	
	public Grid(int scale) {
		this.scale = scale;
		dotsContainer = new ArrayList<Dots> ();
		initDotsDisplay();
		dotsDisplay = getDotsDisplay();
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return scale;
	}

	public void initDotsDisplay() {

		char [] [] dotsDisplay = new char [getScale()][getScale()];

		for (int a = getScale() - 1; a >= 0; a --)
			for (int b = 0; b < getScale(); b ++)
				dotsDisplay [b][a] = ' ';

		this.dotsDisplay = dotsDisplay;
	}

	public char [] [] getDotsDisplay() {
		return dotsDisplay;
	}

	public Dots addDot(int posX, int posY, char symbol){
		
		Dots dot = null;
		
		if (dotsDisplay[posX][posY] == ' ')
		{
			dotsDisplay[posX][posY] = symbol;
			dot = new Dots(posX, posY, symbol);
			dotsContainer.add(dot);
			return dot;
		}
			return dot;
	}
	
	public Dots getNeighbor(int posX, int posY, char symbol) {
		
		Dots neighbor = new Dots(posX, posY, symbol);
		
		for (int i = 0; i < dotsContainer.size(); i ++)
			if (dotsContainer.get(i) == neighbor)
			{
				System.out.println("Neighbor found.");
				return neighbor;
			}
		
		return null;
	}

	public static void gridDisplay(int scale, char [] [] dotsDisplay) {

		int top = 4 * (scale + 1);
		int middle = 2 + scale;
		int intersection = 1 + scale;
		int bottom = 1 + scale;

		if (scale < 10)
			System.out.print("   ");
		else
			System.out.print("    ");
		for (int a = 0; a < top - 1; a ++)		//Prints top
			System.out.print("_");

		for (int b = scale - 1; b >= 0; b --)	//Prints all of middle sections
		{
			System.out.println(" ");

			if (scale < 10)
				System.out.print("  ");
			else
				System.out.print("   ");
			for (int c = 0; c < middle - 1; c ++)	//Prints columns
				System.out.print("|   ");
			System.out.print("|");

			System.out.println(" ");

			if (scale >= 10)
			{
				if ((b + 1) < 10)
					System.out.print((b + 1) + "  |");
				else
					System.out.print((b + 1) + " |");
			}
			else
				System.out.print((b + 1) + " |");
			for (int d = 0; d < intersection - 1; d ++)		//Prints intersections + numbers left of grid
				System.out.print("---" + dotsDisplay[d][b]);
			System.out.print("---|");
		}

		System.out.println(" ");

		if (scale < 10)
			System.out.print("  ");
		else
			System.out.print("   ");
		for (int e = 0; e < bottom; e ++)		//Prints bottom
			System.out.print("|___");
		System.out.print("|");

		System.out.println(" ");

		if (scale < 10)
			System.out.print("   ");
		else
			System.out.print("    ");
		for (int f = 0; f < scale; f ++)		//Prints numbers below grid
			if (f < 10)
				System.out.print("   " + (f+1));
			else
				System.out.print("  " + (f+1));
	}
}
