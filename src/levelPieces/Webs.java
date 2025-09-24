package levelPieces;

import gameEngine.Drawable;
/**
 * Webs class
 * Webs are an object that just gets drawn on the board with no additional
 * behavior.
 * Our 1 object that does not move or interact with the player
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/24/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class Webs implements Drawable {
	protected char symbol;
	
	public Webs(char symbol) {
		this.symbol = '#';
	}
	
	public void draw() {
		System.out.print(symbol);
	}
}
