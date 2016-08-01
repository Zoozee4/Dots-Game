
public class Grid {

	public static String [] [] initMatrix(int scale, String [] [] dotsList) {

		for (int rows = 0; rows < scale; rows ++)
			for (int columns = 0; columns < scale; columns ++)
				dotsList [rows][columns] = "X";
		return dotsList;
	}

	public static void gridDisplay(int scale, String [] [] dotsList) {

		int top = 4 * (scale + 1);
		int middle = 2 + scale;
		int intersection = 1 + scale;
		int bottom = 1 + scale;

		System.out.print(" ");
		for (int a = 0; a < top - 1; a ++)
			System.out.print("_");
		
		for (int b = 0; b < scale; b ++)
		{
		System.out.println(" ");

		for (int c = 0; c < middle - 1; c ++)
			System.out.print("|   ");
		System.out.print("|");
		
		System.out.println(" ");

		System.out.print("|");
		for (int d = 0; d < intersection - 1; d ++)
			System.out.print("---" + dotsList[d][b]);
		System.out.print("---|");
		}
		
		System.out.println(" ");
		
		for (int e = 0; e < bottom; e ++)
			System.out.print("|___");
		System.out.print("|");
		
	}

	public static void main(String [] args) {
		Controller object = new Controller();
		int scale = object.setScale(9);		//Change 9 to anything if you want to change the scale.
		int gamemode;
		String [] [] dotsList = new String [scale][scale];
		

		object.dotsList = initMatrix(scale, dotsList);
		gamemode = object.setGamemode();
		gridDisplay(scale, object.dotsList);
	}
}
