import java.util.*;
import java.awt.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);
	Player player1;
	Player player2;
	Grid grid;
	Node node;

	public static final int LEVEL_DFS = 50;

	public Controller() {

	}

	public void playGame() {

		String name;
		char symbol;
		int currentPlayer;
		int scale = 9;			//Change the 9 if you want to change the scale

		if (scale != 9)
		{
			System.out.print("What would you like the scale to be (5-12)? ");
			while (scale < 5 || scale > 12)
				scale = Input.nextInt();
		}
		grid = new Grid(scale);

		System.out.print("First player, please input your name (Your symbol will be 'O'): ");
		name = Input.next();
		symbol = 'O';
		player1 = new Player(name, symbol);

		System.out.print("Second player, please input your name (Your symbol will be 'X'): ");
		name = Input.next();
		symbol = 'X';
		player2 = new Player(name, symbol);

		currentPlayer = randFirstPlayer();

		while (gameover() != true){
			grid.gridDisplay(grid.getScale(), grid.getDotsDisplay());
			Dots currentDot = locator(getCurrentPlayer(currentPlayer));
			checkTerritory(currentDot);
			currentPlayer = flipPlayer(currentPlayer);
		}
	}

	public Dots locator(Player player) {
		int posX = 0;
		int posY = 0;
		Dots dot = null;

		System.out.println("\n\n" + player.getName() + ", type in coordinates to place your dot.");

		while (dot == null)
		{
			posX = 0;
			posY = 0;

			System.out.println(" ");

			while (posX < 1 || posX > grid.getScale())
			{
				System.out.print("X : ");
				posX = Input.nextInt();
			}
			while (posY < 1 || posY > grid.getScale())
			{
				System.out.print("Y : ");
				posY = Input.nextInt();
			}

			dot = grid.addDot(posX - 1, posY - 1, player.getSymbol());
		}
		return dot;
	}

	public void checkTerritory(Dots currentDot) {

		grid.resetNodes(currentDot.getSymbol());

		Node root = grid.getNode(currentDot.getPosX(), currentDot.getPosY(), currentDot.getSymbol());
		root.setFather(true);

		Node path = DepthFirstSearch(root, root, 0);

		/*if (path != null) {		// we have found out a path then we have to check all stuff that we discussed 
			System.out.println("Path found.");
			Polygon polygon = new Polygon(); /// you need to get the pos X and pos Y .. and build the polygon and check the stuff 
		}*/
	}

	public Node DepthFirstSearch(Node root, Node node, int level) {
		
		node.setDiscovered(true);

		if (level > LEVEL_DFS)
		{
			System.out.println("Not found");
			return null;
		}

		if (level >= 4 && root.getFather() == node.getFather()) {	//we found the path!!
			System.out.println("Found path at level : " + level);
			return node;
		}
		
		/*if (level > 0)
			node.setFather(false);*/
		
		grid.checkAdjacentDots(node);
		
		Node child = null;

		Iterator<Node> iterator = node.getChildList().iterator();
		while(iterator.hasNext())
		{
			child = iterator.next();

			if (child.getDiscovered() == false)
			{
				DepthFirstSearch(root, child, ++ level);
			}
		}
		return null;
	}

	public int randFirstPlayer() {
		Random rand = new Random();

		int num = Math.abs(rand.nextInt());

		return (num % 2 + 1);
	}

	public int flipPlayer(int currentPlayer) {

		if (currentPlayer == 1)
			return 2;
		else
			return 1;
	}

	public Player getCurrentPlayer(int currentPlayer) {
		if (currentPlayer == 1)
			return player1;
		else
			return player2;
	}

	public boolean gameover() {
		for (int a = 0; a < grid.getScale(); a ++)
			for (int b = 0; b < grid.getScale(); b ++)
			{
				if (grid.getDotsDisplay() [b] [a] == ' ')
					return false;
			}
		return true;
	}

	public static void main(String [] args) {
		Controller object = new Controller();
		object.playGame();
	}
}
