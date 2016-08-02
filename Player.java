import java.util.*;
import java.io.*;

public class Player {
	Scanner Input = new Scanner(System.in);
	Controller object;
	
	public String [] playerNames;
	public int currentPlayer;
	public int [] scoreDisplay;
	public int [] [] playersDots;
	
	public Player () {
		object = new Controller(0);
		playerNames = setNames();
		currentPlayer = 1;		//TODO randomize currentPlayer
	}
	
	public String [] setNames() {
		
		String [] names = new String [2];
		
		if (object.gamemode == 1)
		{
			System.out.print("What is your name : ");
			names [0] = Input.next();
			names [1] = "Computer";
		}
		else
		{
			System.out.print("First player's name (Your dot is represented with an 'O') : ");
			names [0] = Input.next();
			System.out.print("Second player's name (Your dot is represented with an 'X') : ");
			names [1] = Input.next();
		}
		
		return names;
	}
}
