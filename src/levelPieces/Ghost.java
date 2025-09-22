package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Ghost extends GamePiece {

	public Ghost(int location) {
		super('&', "Ghost", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
}
