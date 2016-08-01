import java.util.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);
	Grid grid;

	public int preset;
	public int scale;
	public int gamemode;
	public int currentPlayer;
	public String [] [] dotsList;
	public boolean gameover = false;

	public Controller () {
		grid = new Grid();
		preset = 9;				//Change to anything other that 9 if you want to change the scale.
		scale = setScale();
		dotsList = initMatrix();
		//gamemode = setGamemode();
	}

	public int setScale() { 	

		if (preset != 9)
		{
			while (scale < 5 || scale > 99) 
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
			this.gamemode = gamemode;
		}
		return this.gamemode;
	}

	public String [] [] initMatrix() {

		String [] [] dotsList = new String [scale] [scale];

		for (int rows = 0; rows < scale; rows ++)
			for (int columns = 0; columns < scale; columns ++)
				dotsList [rows][columns] = " ";
		return dotsList;
	}

	public void locator() {
		int x = 0;
		int y = 0;
		boolean check = false;

		
		while (check == false)
		{
			System.out.println("\n\nType in coordinates to place your dot.");
			
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
			if (dotsList [x] [y] != "O")
			{
				dotsList [x] [y] = "O";
				check = true;
			}
		}
	}
}
