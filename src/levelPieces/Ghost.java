package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
/**
 * Ghost class
 * Ghosts stay in a single spot, but instantly kill the player when they
 * interact with them.
 * 1 of the 4 game pieces that does not move but interacts with the player.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/24/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class Ghost extends GamePiece {

	public Ghost(int location) {
		super('&', "Ghost", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == playerLocation) { // Insta-Kill's the player
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
}
