package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
/**
 * Zombie class
 * Zombies will always try to move 1 space towards the player, but will
 * not move if another object is in their way. If they are on the same
 * space as the player, they will hit them.
 * 1 of our 2 moveable game pieces that interact with the player.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/24/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class Zombie extends GamePiece implements Moveable {

	public Zombie(int location) {
		super('Z', "Zombie", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation < this.getLocation() // Always moves towards the player if possible.
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
		if (this.getLocation() == playerLocation) { // If they are on the same tile, deal damage
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
