
public class Player {
	
	private String name;
	private char symbol;
	private int score;
	
	public Player(String name, char symbol, int score) {
		this.name = name;
		this.symbol = symbol;
		this.score = score;
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
