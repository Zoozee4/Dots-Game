import java.util.*;

public class Display {

	public Display() {

	}

	public void gridDisplay(int scale, char [] [] dotsDisplay, Player player1, Player player2) {

		int top = 4 * (scale + 1);
		int middle = 2 + scale;
		int intersection = 1 + scale;
		int bottom = 1 + scale;
		
		
		if (scale < 10)
			System.out.println("\n  " + player1.getName() + "'s Score : " + player1.getScore() + " 	" + player2.getName() + "'s Score : " + player2.getScore());
		else
			System.out.println("\n   " + player1.getName() + "'s Score : " + player1.getScore() + " 	" + player2.getName() + "'s Score : " + player2.getScore());
		
		
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
				System.out.print("   " + (f + 1));
			else
				System.out.print("  " + (f + 1));
	}

	public void nodeStatsDisplay(String nodeName, Node node) {

		System.out.println("\n----------------------------------------------------");

		System.out.println("Current " + nodeName + " stats : ");

		System.out.println(" ");
		
		if (node.getFather() != null)
		{
			System.out.println("Father's saved dot stats : ");
			System.out.println("X : " + (node.getFather().getSavedDot().getPosX() + 1));
			System.out.println("Y : " + (node.getFather().getSavedDot().getPosY() + 1));
			System.out.println("Symbol : " + node.getFather().getSavedDot().getSymbol());
		}
		else
			System.out.println("This node doesn't have a father.");

		System.out.println(" ");

		System.out.println("Saved dot stats : ");
		System.out.println("X : " + (node.getSavedDot().getPosX() + 1));
		System.out.println("Y : " + (node.getSavedDot().getPosY() + 1));
		System.out.println("Symbol : " + node.getSavedDot().getSymbol());

		System.out.println(" ");

		if (!node.getChildList().isEmpty())
		{
			int count = 0;

			System.out.println("Children : ");

			Iterator<Node> iterator = node.getChildList().iterator();

			while (iterator.hasNext())
			{
				count ++;

				Node child = iterator.next();
				
				System.out.println(count + " - Child : (X : " + (child.getSavedDot().getPosX() + 1) + ") , (Y : " + (child.getSavedDot().getPosY() + 1) + ") , (Symbol : " + child.getSavedDot().getSymbol() + ").");
			}
		}
		else
			System.out.println("This node has no children.");

		System.out.println("----------------------------------------------------");
	}

	public void discoveredNodesDisplay(ArrayList<Node> discoveredNodes) {

		System.out.println("\n----------------------------------------------------");

		System.out.print("Discovered nodes : ");

		int count = 0;

		Iterator<Node> iterator = discoveredNodes.iterator();

		if (!discoveredNodes.isEmpty())
			while (iterator.hasNext())
			{
				count ++;
				
				Node node = iterator.next();
				
				System.out.println(" ");
				
				if (node.getFather() != null)
					System.out.println(count + " - Father : (X : " + (node.getFather().getSavedDot().getPosX() + 1) + ") , (Y : " + (node.getFather().getSavedDot().getPosY() + 1) + ") , (Symbol : " + node.getFather().getSavedDot().getSymbol() + ") , (Child count : " + node.getFather().getChildList().size() + ").");
				else
					System.out.println(count + " - Father : Null.");
				
				System.out.println(count + " - Node : (X : " + (node.getSavedDot().getPosX() + 1) + ") , (Y : " + (node.getSavedDot().getPosY() + 1) + ") , (Symbol : " + node.getSavedDot().getSymbol() + ") , (Child count : " + node.getChildList().size() + ").");
			}

		System.out.println("----------------------------------------------------");
	}

	public void pathDisplay (Node path) {
		
		int count = 0;
		
		while (path != null)
		{
			count ++;
			
			System.out.println(count + " - Node : (X : " + (path.getSavedDot().getPosX() + 1) + ") , (Y : " + (path.getSavedDot().getPosY() + 1) + ") , (Symbol : " + path.getSavedDot().getSymbol() + ").");
			
			path = path.getFather();
		}
	}
	
	public void unplayableSpacesDisplay(int scale, int [] [] unplayableSpaces) {
		for (int a = scale - 1; a >= 0; a --)
		{
			for (int b = 0; b < scale; b ++)
			{
				System.out.print(unplayableSpaces [b][a] + " ");
			}
			System.out.println(" ");
		}
	}

}