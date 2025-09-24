package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

// 1 of the 4 game pieces that do not move but interact with the player.

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
