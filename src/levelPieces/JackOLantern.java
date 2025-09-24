package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

// 1 of the 4 game pieces that do not move but interact with the player.

public class JackOLantern extends GamePiece {

	public JackOLantern(int location) {
		super('@', "Jack O' Lantern", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}
