import java.util.*;
import java.io.*;

public class Controller {
	Scanner Input = new Scanner(System.in);

	public int scale;
	public int gamemode;
	public int currentPlayer;
	public String [] [] dotsList = new String [scale] [scale];

	public int setScale(int preset) {
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
		this.gamemode = gamemode;
		}
		return this.gamemode;
	}
}
