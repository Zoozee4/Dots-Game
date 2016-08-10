
public class Dots {
	
	private int posX;
	private int posY;
	private char symbol;
	
	public Dots(int x, int y, char symbol) {
		this.posX = x;
		this.posY = y;
		this.symbol = symbol;
	}
	
	public void setCoordinates(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setSymbol() {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	
}
