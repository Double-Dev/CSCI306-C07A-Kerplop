package levelPieces;

import gameEngine.Drawable;

public class Webs implements Drawable {
	protected char symbol;
	
	public Webs(char symbol) {
		this.symbol = 'W';
	}
	
	public void draw() {
		System.out.print(symbol);
	}
}
