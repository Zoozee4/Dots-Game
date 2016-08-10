import java.util.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);
	Player player1;
	Player player2;
	Grid grid;

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
			checkTerritory(grid.getDotsDisplay(), currentDot);
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

		return (dot);
	}

	public void checkTerritory(char [] [] dotsDisplay, Dots currentDot) {

		checkAdjacentDots(dotsDisplay, currentDot);

	}

	public void checkAdjacentDots(char [] [] dotsDisplay, Dots currentDot) {

		for (int y = currentDot.getPosY() - 1; y <= currentDot.getPosY() + 1; y ++)
			for (int x = currentDot.getPosX() - 1; x <= currentDot.getPosX() + 1; x ++)
			{
				if (currentDot.getPosX() > 0 && currentDot.getPosX() < grid.getScale() - 1 && currentDot.getPosY() > 0 && currentDot.getPosY() < grid.getScale() - 1)		//Checks everything other than edges and corners
				{
					if (x != currentDot.getPosX() || y != currentDot.getPosY())
					{
						if (dotsDisplay[x][y] == currentDot.getSymbol())
							System.out.println("X : " + (x + 1) + "  Y : " + (y + 1));
					}
				}
				
				
				if (currentDot.getPosX() == 0 && currentDot.getPosY() == 0)						//Bottom left corner
				{
					if ((x != currentDot.getPosX() || y != currentDot.getPosY()) && (x >= 0 && x < 2) && (y >= 0 && y < 2))
					{
						if (dotsDisplay[x][y] == currentDot.getSymbol())
							System.out.println("X : " + (x + 1) + "  Y : " + (y + 1));
					}
				}
				
				
				if (currentDot.getPosX() == grid.getScale() - 1 && currentDot.getPosY() == 0)						//Bottom right corner
				{
					if ((x != currentDot.getPosX() || y != currentDot.getPosY()) && (x > grid.getScale() - 3 && x <= grid.getScale() - 1) && (y >= 0 && y < 2))
					{
						if (dotsDisplay[x][y] == currentDot.getSymbol())
							System.out.println("X : " + (x + 1) + "  Y : " + (y + 1));
					}
				}
				
				
				if (currentDot.getPosX() == 0 && currentDot.getPosY() == grid.getScale() - 1)						//Top left corner
				{
					if ((x != currentDot.getPosX() || y != currentDot.getPosY()) && (x >= 0 && x < 2) && (y > grid.getScale() - 3 && y <= grid.getScale() - 1))
					{
						if (dotsDisplay[x][y] == currentDot.getSymbol())
							System.out.println("X : " + (x + 1) + "  Y : " + (y + 1));
					}
				}
				
				
				if (currentDot.getPosX() == grid.getScale() - 1 && currentDot.getPosY() == grid.getScale() - 1)						//Top right corner
				{
					if ((x != currentDot.getPosX() || y != currentDot.getPosY()) && (x > grid.getScale() - 3 && x <= grid.getScale() - 1) && (y > grid.getScale() - 3 && y <= grid.getScale() - 1))
					{
						if (dotsDisplay[x][y] == currentDot.getSymbol())
							System.out.println("X : " + (x + 1) + "  Y : " + (y + 1));
					}
				}
				
				
			}

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
