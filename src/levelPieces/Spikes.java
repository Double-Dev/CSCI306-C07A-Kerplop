package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
/**
 * Spikes class
 * Spikes stay in a single spot and hit the player when they interact
 * with them.
 * 1 of the 4 game pieces that does not move but interacts with the player.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/26/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class Spikes extends ContactDamagePiece implements Drawable {
	public Spikes(int location) {
		super('^', "Spikes", location);
	}
}
