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
 * Date: 9/26/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class SpookySkeleton extends ContactDamagePiece implements Moveable {
	private static final java.util.Random rand = new java.util.Random();
	
	public SpookySkeleton(int location) {
		super('W', "Spooky Scary Skeleton!", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int move = rand.nextInt(5) - 2; // Chooses a random number to move from -2 to 2
		
		// Move to the generated amount only if nothing is there.
		if (gameBoard[this.getLocation() + move] == null) {
			gameBoard[this.getLocation()] = null;
			this.setLocation(this.getLocation() + move);
			gameBoard[this.getLocation()] = this;
		}
	}
}
