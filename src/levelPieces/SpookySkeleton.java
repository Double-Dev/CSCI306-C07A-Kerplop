package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

// 1 of our 2 moveable game pieces that interacts with the Player

public class SpookySkeleton extends GamePiece implements Moveable {
	public SpookySkeleton(char symbol, String label, int location) {
		super(symbol, label, location);
		this.symbol = 'W';
	}
	
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) { // If they are on the same tile, deal damage
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
}
