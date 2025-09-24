package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
/**
 * SpookySkeleton class
 * SpookySkeletons can move randomly in a range of 2 spaces to the left to 2 spaces
 * to the right (including staying in the same spot). It hits the player if they
 * interact (move to the same spot).
 * 1 of our 2 moveable game pieces that interact with the player
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/24/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class SpookySkeleton extends GamePiece implements Moveable {
	private java.util.Random rand = new java.util.Random();
	
	public SpookySkeleton(int location) {
		super('W', "Spooky Scary Skeleton!", location);
	}
	
	
	public void move(Drawable[] gameBoard, int playerLocation) { // A wildcard that can move anywhere from 2 to the left or 2 to the right
		int[] moving = {-2, -1, 0, 1, 2};
		int randnum = rand.nextInt(5) - 1;
		int leap = moving[randnum]; // Chooses a random number to move from -2 to 2
		
		// Move to the generated spot only if nothing is there.
		if (gameBoard[this.getLocation() + leap] != null) {
			this.setLocation(this.getLocation() + leap);
		}
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) { // If they are on the same tile, deal damage
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}
}
