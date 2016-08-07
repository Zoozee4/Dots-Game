import java.util.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);
	Player player1;
	Player player2;
	Grid grid;

	public Controller () {
		grid = new Grid();
	}

	public void playGame() {

		String name;
		char symbol;

		System.out.println("First player, please input your name (Your symbol will be 'O'): ");
		name = Input.next();
		symbol = 'O';
		player1 = new Player(name, symbol);
		System.out.println("Second player, please input your name (Your symbol will be 'X'): ");
		name = Input.next();
		symbol = 'X';
		player2 = new Player(name, symbol);

		while (gameover() != true){
			grid.gridDisplay(grid.getScale(), grid.getDotsDisplay());
			locator(player1);
			grid.gridDisplay(grid.getScale(), grid.getDotsDisplay());
			locator(player2);
			checkTerritory();
		}
	}

	public void locator(Player player) {

		boolean check = false;

		System.out.println("\n\n" + player.getName() + ", type in coordinates to place your dot.");

		while (check == false)
		{
			int posX = 0;
			int posY = 0;

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

			grid.addDot(posX - 1, posY - 1, player1.getSymbol());

			if (grid.getDotsDisplay()[posX][posY] != 'O' && grid.getDotsDisplay()[posX][posY] != 'X')
			{
				grid.getDotsDisplay()[posX][posY] = 'O';
				check = true;
			}
			else if (grid.getDotsDisplay()[posX][posY] != 'X' && grid.getDotsDisplay()[posX][posY] != 'O')
			{
				grid.getDotsDisplay()[posX][posY] = 'X';
				check = true;
			}
		}
	}
	
	public void randFirstPlayer() {
		
	}
	
	public void flipPlayer() {
		
	}
	
	public void checkTerritory() {
		
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
