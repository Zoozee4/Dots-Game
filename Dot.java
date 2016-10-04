
public class Dot {
	
	private int posX;
	private int posY;
	private char symbol;
	
	public Dot(int x, int y, char symbol) {
		this.posX = x;
		this.posY = y;
		this.symbol = symbol;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
