import java.util.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);
	Grid grid;
	Player player;

	private int preset;
	private int scale;
	private int gamemode;
	private char [] [] dotsDisplay;

	public Controller () {
		grid = new Grid();
		preset = 9;				//Change to anything other that 9 if you want to change the scale.
		setScale();
		scale = getScale();
		setMatrix();
		dotsDisplay = getMatrix();
		player = new Player();
	}

	public Controller (int gamemode) {
		setGamemode();
		this.gamemode = getGamemode();
	}

	public void setScale() { 	
		if (preset != 9)
		{
			while (scale < 5 || scale > 12) 
			{
				System.out.print("What would you like the scale to be (5 - 12)? ");
				scale = Input.nextInt();
			}
			preset = scale;
		}
	}

	public int getScale() {
		if (preset != 9)
			return scale;
		else
			return preset;
	}

	public void setGamemode() {
		gamemode = 0;

		while (gamemode != 1 && gamemode != 2) 
		{
			System.out.print("Choose a gamemode 1) Singleplayer, 2) Multiplayer : ");
			gamemode = Input.nextInt();
		}
	}

	public int getGamemode() {
		return gamemode;
	}

	public void setMatrix() {

		char [] [] dotsDisplay = new char [scale] [scale];

		for (int rows = 0; rows < scale; rows ++)
			for (int columns = 0; columns < scale; columns ++)
				dotsDisplay [rows][columns] = ' ';

		this.dotsDisplay = dotsDisplay;
	}

	public char [] [] getMatrix() {
		return dotsDisplay;
	}

	public void locator() {

		boolean check = false;

		if (player.getCurrentPlayer() == 1 || player.getNames()[1] != "Computer")
		{

			System.out.println("\n\n" + player.getNames()[player.getCurrentPlayer() - 1] + ", type in coordinates to place your dot.");

			while (check == false)
			{
				int x = 0;
				int y = 0;

				System.out.println(" ");

				while (x < 1 || x > scale)
				{
					System.out.print("X : ");
					x = Input.nextInt();
				}
				while (y < 1 || y > scale)
				{
					System.out.print("Y : ");
					y = Input.nextInt();
				}

				x -= 1;
				y -= 1;

				if (dotsDisplay [x] [y] != 'O' && dotsDisplay [x] [y] != 'X' && player.getCurrentPlayer() == 1)
				{
					dotsDisplay [x] [y] = 'O';
					player.flipPlayer(player.getCurrentPlayer());
					check = true;
				}
				else if (dotsDisplay [x] [y] != 'X' && dotsDisplay [x] [y] != 'O'  && player.getCurrentPlayer() == 2)
				{
					dotsDisplay [x] [y] = 'X';
					player.flipPlayer(player.getCurrentPlayer());
					check = true;
				}
			}
		}
		else
			locatorAI();
	}

	private void locatorAI() {
		Random num = new Random();

		int rand = Math.abs(num.nextInt());
		int x;
		int y;
		boolean check = false;
		
		System.out.println(" ");

		while (check == false)
		{
			x = (rand % getScale());
			y = (rand % getScale());

			if (dotsDisplay [x] [y] == ' ')
			{
				dotsDisplay [x] [y] = 'X';
				check = true;
			}
		}
		player.flipPlayer(player.getCurrentPlayer());
	}

	public boolean gameover() {
		for (int a = 0; a < scale; a ++)
			for (int b = 0; b < scale; b ++)
			{
				if (dotsDisplay [b] [a] == ' ')
					return false;
			}
		return true;
	}
}
