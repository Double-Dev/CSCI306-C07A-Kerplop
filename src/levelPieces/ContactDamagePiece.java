package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
/**
 * ContactDamagePiece class
 * Implements the interaction logic for all pieces that hurt the player
 * on contact.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/26/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public abstract class ContactDamagePiece extends GamePiece {
	public ContactDamagePiece(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
