package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
/**
 * JackOLantern class
 * JackOLanterns stay in the same spot and give a point to the player when
 * they interact. Afterwards, the JackOLantern's symbol changes to indicate
 * that it has been collected.
 * 1 of the 4 game pieces that does not move but interacts with the player.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/24/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class JackOLantern extends GamePiece {
	public JackOLantern(int location) {
		super('@', "Jack O' Lantern", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// Gives the Player a point if not yet collected
		if (this.getLocation() == playerLocation && this.symbol != ' ') {
			// Using symbol to indicate it has been collected
			this.symbol = ' ';
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}
