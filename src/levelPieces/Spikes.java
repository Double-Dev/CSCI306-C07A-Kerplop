package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Spikes extends GamePiece implements Drawable {
	
	public Spikes(char symbol, String label, int location) {
		super(symbol, label, location);
		this.symbol = '^';
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
	
}
