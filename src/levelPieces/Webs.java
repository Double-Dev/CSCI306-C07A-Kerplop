package levelPieces;

import gameEngine.Drawable;


// Our 1 object that does not move or interact with the player

public class Webs implements Drawable {
	protected char symbol;
	
	public Webs(char symbol) {
		this.symbol = '#';
	}
	
	public void draw() {
		System.out.print(symbol);
	}
}
