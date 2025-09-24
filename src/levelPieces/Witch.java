package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

// Our 1 character that attacks from a range, but can only attack from a range and is stationary
// 1 of the 4 game pieces that do not move but interact with the player.

public class Witch extends GamePiece implements Drawable {
	public Witch(int location) {
		super('V', "Witch", location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == (this.getLocation() - 1) || playerLocation == (this.getLocation() - 2)) { 
			return InteractionResult.HIT; // If they are 1 or 2 tiles ahead, deal damage.
		}
		else { // Once you reach the witch or pass her, you are safe
			return InteractionResult.NONE;
		}
	}
}
