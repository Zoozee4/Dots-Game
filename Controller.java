import java.util.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);
	Grid grid;
	Player player;

	private int preset;
	private int scale;
	private int gamemode;
	private int [] [] playerDots;
	private char [] [] dotsDisplay;
	

	public Controller () {
		grid = new Grid();
		preset = 9;				//Change to anything other that 9 if you want to change the scale.
		setScale();
		scale = getScale();
		initMatrix();
		player = new Player();
	}

	public Controller (int constructor1) {
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

	public void initMatrix() {
		
		int [] [] matrix1 = new int [getScale()] [getScale()];
		char [] [] matrix2 = new char [getScale()] [getScale()];
		
		for (int rows = 0; rows < scale; rows ++)
			for (int columns = 0; columns < scale; columns ++)
			{
				matrix1 [rows][columns] = 0;
				matrix2 [rows][columns] = ' ';
			}
		
		playerDots = matrix1;
		dotsDisplay = matrix2;
		
	}
	
	public char [] [] getDotsDisplay() {
		return dotsDisplay;
	}
	
	public void setPlayerDots(int x, int y) {
		if (player.getCurrentPlayer() == 1)
			playerDots [x] [y] = 1;
		else
			playerDots [x] [y] = 2;
	}
	
	public int [] [] getPlayerDots() {
		return playerDots;
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
					setPlayerDots(x, y);
					player.flipPlayer(player.getCurrentPlayer());
					check = true;
				}
				else if (dotsDisplay [x] [y] != 'X' && dotsDisplay [x] [y] != 'O'  && player.getCurrentPlayer() == 2)
				{
					dotsDisplay [x] [y] = 'X';
					setPlayerDots(x, y);
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

		int rand1 = Math.abs(num.nextInt());
		int rand2 = Math.abs(num.nextInt());
		int x;
		int y;
		boolean check = false;
		
		System.out.println("\n ");
		System.out.println(player.getNames()[1] + " turn...");

		while (check == false)
		{
			x = (rand1 % getScale());
			y = (rand2 % getScale());

			if (dotsDisplay [x] [y] == ' ')
			{
				dotsDisplay [x] [y] = 'X';
				setPlayerDots(x, y);
				check = true;
			}
		}
		player.flipPlayer(player.getCurrentPlayer());
	}
	
	public void checkTerritory() {
		
		boolean check = false;
		int small = 0;
		
		if (player.getCurrentPlayer() == 1)
		{
			for (int a = 1; a < getScale() - 1; a ++)
				for (int b = 1; b < getScale() - 1; b ++)
				{
					while (playerDots [b] [a] == 2 && check == false)
					{
						if (playerDots [b + 1] [a] == 1 && playerDots [b] [a + 1] == 1 && playerDots [b - 1] [a] == 1 && playerDots [b] [a - 1] == 1)
							player.getScoreDisplay()[0] += 1;
					}
				}
		}
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
