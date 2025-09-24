package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
/**
 * Witch class
 * Witches stay in the same place but can hit the player if they are 2 spaces to the
 * left of them.
 * Our 1 piece that attacks from a range, but can only attack from a range and is stationary
 * 1 of the 4 game pieces that does not move but interacts with the player.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/24/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class Witch extends GamePiece implements Drawable {
	public Witch(int location) {
		super('V', "Witch", location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == (this.getLocation() - 2)) { 
			return InteractionResult.HIT; // If they are 2 tiles to the left, deal damage.
		}
		else { // Once you reach the witch or pass her, you are safe
			return InteractionResult.NONE;
		}
	}
}
