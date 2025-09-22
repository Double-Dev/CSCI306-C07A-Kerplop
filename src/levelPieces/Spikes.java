package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

// 1 of the 4 game pieces that do not move but interact with the player.

public class Spikes extends GamePiece implements Drawable {
	
	public Spikes(int location) {
		super('^', "Spikes", location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) { // If they are on the same tile, deal damage
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
	
}
