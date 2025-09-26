package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
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
 * Date: 9/26/2025
 * Collaborators: N/A
 * Sources: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
 */
public class Zombie extends ContactDamagePiece implements Moveable {

	public Zombie(int location) {
		super('Z', "Zombie", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Always moves towards the player if possible, while staying within level boundaries.
		// Doesn't move into occupied spaces.
		if (playerLocation < this.getLocation() // Checking if left move is valid
				&& gameBoard[Math.max(0, this.getLocation()-1)] == null) {
			this.setLocation(gameBoard, this.getLocation()-1);
		} else if (playerLocation > this.getLocation() // Checking if right move is valid
				&& gameBoard[Math.min(GameEngine.BOARD_SIZE-1, this.getLocation()+1)] == null) {
			this.setLocation(gameBoard, this.getLocation()+1);
		}
	}
}
