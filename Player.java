import java.util.*;
import java.io.*;

public class Player {
	Scanner Input = new Scanner(System.in);
	Controller object;

	private String [] playerNames;
	private int currentPlayer;
	//public int [] scoreDisplay;

	public Player () {
		object = new Controller(0);
		setNames();
		playerNames = getNames();
		flipPlayer(randFirstPlayer());
		currentPlayer = getCurrentPlayer();
	}

	public void setNames() {

		String [] names = new String [2];

		if (object.getGamemode() == 1)
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

		this.playerNames = names;
	}

	public String [] getNames() {
		return playerNames;
	}

	public int randFirstPlayer() {
		Random num = new Random();

		int rand = Math.abs(num.nextInt());

		return (rand % 2 + 1);
	}

	public void flipPlayer(int currentPlayer) {
		if (currentPlayer == 1)
			currentPlayer = 2;
		else
			currentPlayer = 1;
		
		this.currentPlayer = currentPlayer;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}
}
