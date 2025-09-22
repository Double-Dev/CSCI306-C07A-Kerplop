package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Zombie extends GamePiece implements Moveable {

	public Zombie(int location) {
		super('Z', "Zombie", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation < this.getLocation()
				&& this.getLocation() > 0
				&& gameBoard[this.getLocation()-1] == null) {
			this.setLocation(this.getLocation()-1);
		} else if (playerLocation > this.getLocation()
				&& this.getLocation() < GameEngine.BOARD_SIZE-1
				&& gameBoard[this.getLocation()+1] == null) {
			this.setLocation(this.getLocation()+1);
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
