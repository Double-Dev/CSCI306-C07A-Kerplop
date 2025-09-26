package levelPieces;

import java.util.Random;

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
 * Sources: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
 */
public class SpookySkeleton extends GamePiece implements Moveable {
	private static final Random rand = new Random();
	
	public SpookySkeleton(int location) {
		super('W', "Spooky Scary Skeleton!", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int move = rand.nextInt(5) - 2; // Chooses a random number to move from -2 to 2
		
		// Move to the generated amount only if nothing is there.
		if (gameBoard[Math.max(0, Math.min(GameEngine.BOARD_SIZE-1, this.getLocation() + move))] == null) {
			this.setLocation(gameBoard, this.getLocation() + move);
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == (this.getLocation() + 1) || playerLocation == (this.getLocation() - 1)) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
