
public class Grid {
	public static void main(String [] args) {


		int scale = 9;
		String [] [] dotsList = new String [scale][scale];
		
		for (int a = 0; a < scale; a ++)
			for (int b = 0; b < scale; b ++)
				dotsList[a][b] = "-X--";
		
		for (int a = 0; a < scale; a ++) {
			System.out.print("\n|--");
			for (int b = 0; b < scale; b ++)
				System.out.print(dotsList[a][b]);
		}
		/*
		System.out.println(" _______________________________________");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|   |   |   |   |   |   |   |   |   |   |");
		System.out.println("|---|---|---|---|---|---|---|---|---|---|");
		System.out.println("|___|___|___|___|___|___|___|___|___|___|");
		 */
	}
}
