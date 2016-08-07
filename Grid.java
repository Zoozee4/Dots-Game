import java.util.*;
import java.io.*;

public class Grid {
	Scanner Input = new Scanner(System.in);

	private int preset = 0;			//Change the 9 to anything else if you want to change the scale.
	private int scale;
	private char [][] dotsDisplay;

	public Grid(){
		setScale();
		scale = getScale();
		initDotsDisplay();
	}

	public void setScale() {

		int scale = 0;

		if (preset != 9)
		{
			System.out.print("What would you like the scale to be (5 - 12)? ");
			while (scale < 5 || scale > 12)
				scale = Input.nextInt();
			this.scale = scale;
		}
		else
			this.scale = preset;
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

	public void addDot(int posX, int posY, char symbol){
		dotsDisplay [posX][posY] = symbol;
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
