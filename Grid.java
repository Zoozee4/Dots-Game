import java.util.*;
import java.io.*;

public class Grid {

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
