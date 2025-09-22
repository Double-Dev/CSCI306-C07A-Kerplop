package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

// 1 of our 2 moveable game pieces that interacts with the Player

public class SpookySkeleton extends GamePiece implements Moveable {
	public SpookySkeleton(char symbol, String label, int location) {
		super('W', "Spooky Scary Skeleton!", location);
	}
	
	
	public void move(Drawable[] gameBoard, int playerLocation) { // A wildcard that can move anywhere from 2 to the left or 2 to the right
		int[] moving = {-1, -2, 0, 1, 2};
		java.util.Random rand = new java.util.Random();
		int leap = rand.nextInt(5) - 1;
		
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
