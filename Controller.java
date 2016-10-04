import java.util.*;

public class Controller {

	private Player player1;
	private Player player2;
	private Grid grid;
	private Display display;
	Random num = new Random();
	Scanner Input = new Scanner(System.in);

	private static final int DFS_Level = 50;

	public Controller() {
		grid = new Grid();
		display = new Display();
	}

	public void chooseScale() {

		int scale = 9;		//Change the 9 to anything else as it is the preset. If you want the preset, change back to 9.

		if (scale != 9)
		{
			System.out.print("What would you like the scale to be (3 - 99)? ");

			while (scale < 3 || scale > 99)
				scale = Input.nextInt();
		}

		grid.setScale(scale);
		grid.initDotsDisplay(scale);
		grid.initUnplayableSpaces(scale);
	}

	public int chooseGamemode() {

		int choice = 0;

		System.out.print("How many players would you like (1 - 2)? ");

		while (choice < 1 || choice > 2)
			choice = Input.nextInt();

		return choice;
	}

	public void singlePlayerSetup() {

	}

	public void singlePlayerGame() {

	}

	public Player multiPlayerSetup() {

		String name;
		char symbol;
		int score = 0;

		System.out.print("Player 1, please input your name (Your symbol will be 'O'): ");
		name = Input.next();
		symbol = 'O';
		player1 = new Player(name, symbol, score);

		System.out.print("Player 2, please input your name (Your symbol will be 'X'): ");
		name = Input.next();
		symbol = 'X';
		player2 = new Player(name, symbol, score);

		int rand = Math.abs(num.nextInt(2));

		if ((rand + 1) == 1)
			return player1;
		else
			return player2;

	}

	public void multiPlayerGame(Player currentPlayer) {
		
		Dot currentDot;
		int posX;
		int posY;
		Node root;
		Node node;
		Territory territory;
		boolean placedDot;
		boolean gameover = false;

		while (gameover == false) {

			currentDot = null;
			root = null;
			node = null;
			territory = null;
			placedDot = false;

			display.gridDisplay(grid.getScale(), grid.getDotsDisplay(), player1, player2);
			System.out.println("\n");
			System.out.println(currentPlayer.getName() + "'s Turn. Input coordinates to place a dot.");

			while (placedDot == false)
			{
				posX = 0;
				posY = 0;
				
				while (posX < 1 || posY > grid.getScale())
				{
					System.out.print("X : ");
					posX = Input.nextInt();
				}

				while (posY < 1 || posY > grid.getScale())
				{
					System.out.print("Y : ");
					posY = Input.nextInt();
				}

				if (grid.getUnplayableSpaces() [posX - 1] [posY - 1] == 0)
				{
					grid.addUnplayableSpace(posX - 1, posY - 1);
					grid.getDotsDisplay() [posX - 1] [posY - 1] = currentPlayer.getSymbol();
					currentDot = new Dot(posX - 1, posY - 1, currentPlayer.getSymbol());
					root = new Node(null, currentDot);
					placedDot = true;
				}
				else
					System.out.println("\nInvalid move.");
			}

			//DFS process start.

			root = checkNeighbors(root, root, currentPlayer.getSymbol());
			node = new Node(null, root.getSavedDot());

			ArrayList<Node> discoveredNodes = new ArrayList<Node>();
			discoveredNodes.add(root);

			Node path = DFS(root, node, currentPlayer.getSymbol(), discoveredNodes, 0);
			
			//DFS process end.
			
			//Territory process start.
			
			if (path != null)
			{
				territory = new Territory(path, currentPlayer);
				territory.checkPath(grid);
			}
			
			if (grid.getUnclaimedTerritories().size() > 0)
			{
				territory.checkUnclaimedTerritories(grid);
			}

			//Territory process end.
			
			currentPlayer = flipCurrentPlayer(currentPlayer);
		}
	}

	public Player flipCurrentPlayer(Player currentPlayer) {
		if (currentPlayer.getSymbol() == player1.getSymbol())
			return player2;
		else
			return player1;
	}

	public Node checkNeighbors(Node root, Node node, char symbol) {

		Dot currentDot = node.getSavedDot();
		int minX = currentDot.getPosX() - 1;
		int maxX = currentDot.getPosX() + 1;
		int minY = currentDot.getPosY() - 1;
		int maxY = currentDot.getPosY() + 1;
		Dot neighbor = null;
		Node child = null;

		for (int x = minX; x <= maxX ; x ++)
			for (int y = minY; y <= maxY; y ++)
			{
				if ((x >= 0 && x < grid.getScale() && y >= 0 && y < grid.getScale()) && (x != currentDot.getPosX() || y != currentDot.getPosY()))
					if (grid.getDotsDisplay() [x] [y] == symbol)
					{
						neighbor = new Dot(x, y, symbol);

						if (isEqual(root.getSavedDot(), neighbor))
							child = root;
						else
							child = new Node(node, neighbor);

						node.addChild(child);
					}
			}

		return node;
	}

	public Node DFS(Node root, Node node, char symbol, ArrayList<Node> discoveredNodes, int level) {

		Node path = null;

		if (level <= DFS_Level && path == null) {		//Stops recursion when level = 50, or when path is found.
			
			if (!discoveredNodes.contains(node))			//Checks if the node is not discovered already and acts accordingly.
			{
				checkNeighbors(root, node, symbol);
				discoveredNodes.add(node);
			}
			
			if (level > 2 && node.getChildList().contains(root))		//Checks if the root has been found.
			{
				path = node;
				return path;
			}
			
			Iterator<Node> children = node.getChildList().iterator();
			Node child = null;
			
			while (children.hasNext() && child == null)		//Iterates through every child.
			{
				child = children.next();
				
				Iterator<Node> nodeList = discoveredNodes.iterator();
				Dot dot = null;
				
				while (nodeList.hasNext())					//Checks for duplicates.
				{
					dot = nodeList.next().getSavedDot();
					
					if (child != null && isEqual(child.getSavedDot(), dot))
						child = null;
				}
				
				if (child != null)							//Continues recursion if there still is a child.
					path = DFS(root, child, symbol, discoveredNodes, ++ level);
			}
		}
		else
			return path;
		
		return path;
	}

	public boolean isEqual(Dot dot1, Dot dot2) {

		if (dot1.getPosX() == dot2.getPosX() && dot1.getPosY() == dot2.getPosY() && dot1.getSymbol() == dot2.getSymbol())
			return true;
		else
			return false;
	}

	public static void main(String [] args) {
		Controller game = new Controller();
		int gamemode;

		game.chooseScale();
		gamemode = game.chooseGamemode();

		switch (gamemode)
		{
		case 1:
			game.singlePlayerSetup();
			game.singlePlayerGame();
			break;
		case 2:
			Player firstPlayer = game.multiPlayerSetup();
			game.multiPlayerGame(firstPlayer);
			break;
		}
	}
}
