import java.util.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);
	Grid grid;
	Player player;

	public int preset;
	public int scale;
	public int gamemode;
	public String [] [] dotsDisplay;
	public boolean gameover = false;

	public Controller () {
		grid = new Grid();
		preset = 9;				//Change to anything other that 9 if you want to change the scale.
		scale = setScale();
		dotsDisplay = initMatrix();
		player = new Player();
	}
	
	public Controller (int gamemode) {
		this.gamemode = setGamemode();
	}

	public int setScale() { 	

		if (preset != 9)
		{
			while (scale < 5 || scale > 12) 
			{
				System.out.print("What would you like the scale to be (5 - 12)? ");
				scale = Input.nextInt();
			}
			return scale;
		}
		else
			return preset;
	}

	public int setGamemode() {
		int gamemode = 0;

		while (gamemode != 1 && gamemode != 2) 
		{
			System.out.print("Choose a gamemode 1) Singleplayer, 2) Multiplayer : ");
			gamemode = Input.nextInt();
		}
		return gamemode;
	}

	public String [] [] initMatrix() {

		String [] [] dotsDisplay = new String [scale] [scale];

		for (int rows = 0; rows < scale; rows ++)
			for (int columns = 0; columns < scale; columns ++)
				dotsDisplay [rows][columns] = " ";
		return dotsDisplay;
	}

	public void locator() {
		int x = 0;
		int y = 0;
		boolean check = false;


		while (check == false)
		{
			System.out.println("\n\n" + player.playerNames[player.currentPlayer - 1] + ", type in coordinates to place your dot.");

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
			if (dotsDisplay [x] [y] != "O")
			{
				dotsDisplay [x] [y] = "O";
				check = true;
			}
		}
	}

	public boolean gameover() {
		int full = 0;
		int endGame = scale * scale;

		for (int a = 0; a < scale; a ++)
			for (int b = 0; b < scale; b ++)
			{
				if (dotsDisplay [b] [a] != " ")
					full += 1;
			}
		if (full == endGame)
			gameover = true;
		
		return gameover;
	}
}
