import java.util.*;
import java.io.*;

public class Player {

	private String name;
	private char symbol;
	private int score;

	public Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
		score = 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setSymbol(char symbol){
		this.symbol = symbol;
	}
	
	public char getSymbol(){
		return this.symbol;
	}

	public void addScore() {
		score ++;
	}
	
	public int getScore() {
		return score;
	}
}
