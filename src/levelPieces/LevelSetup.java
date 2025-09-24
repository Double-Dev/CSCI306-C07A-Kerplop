package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.Player;

/**
 * LevelSetup class
 * Is the owner of level data, generating it and providing methods for it
 * to be passed back to the GameEngine.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/24/2025
 * Collaborators: N/A
 * Sources: N/A
 */


public class LevelSetup {
	private Drawable[] scenery;
	private ArrayList<GamePiece> pieces;
	private ArrayList<Moveable> moveablePieces;
	private int playerStartLoc;
	
	public LevelSetup() {
		this.scenery = new Drawable[GameEngine.BOARD_SIZE];
		this.pieces = new ArrayList<GamePiece>();
		this.moveablePieces = new ArrayList<Moveable>();
	}

	public void createLevel(int levelNum) {
		// Resetting the level data:
		for (int i = 0; i < this.scenery.length; i++) {
			this.scenery[i] = null;
		}
		this.pieces.clear();
		this.moveablePieces.clear();
		
		// Creating new level data:
		switch (levelNum) {
		case 1: // Level 1
			// Player starts at Spot 0
			// Zombie Starts at Spot 5
			// Witch at Spot 15
			// JackOLanterns at Spots 9 and 20
			// Spikes at Spots 3 and 12
			// Webs at Spots 1, 7, 11, and 17
			Player user = new Player(0);
			Zombie Z1 = new Zombie(5);
			Witch W1 = new Witch(15);
			JackOLantern J1 = new JackOLantern(9);
			JackOLantern J2 = new JackOLantern(20);
			Spikes S1 = new Spikes(3);
			Spikes S2 = new Spikes(13);
			Webs Web = new Webs();
			
			scenery[1] = Web;
			scenery[7] = Web;
			scenery[11] = Web;
			scenery[17] = Web;
			
			pieces.add(Z1);
			pieces.add(W1);
			pieces.add(J1);
			pieces.add(J2);
			pieces.add(S1);
			pieces.add(S2);
			
			moveablePieces.add(Z1);
			
			break;
		case 2:
			break;
			// TODO: Level 2 design.
		default:
			// Error
			break;
		}
	}

	public Drawable[] getBoard() {
		// Creating a duplicate of the current board state to pass back to the GameEngine
		Drawable[] board = this.scenery.clone();
		for (GamePiece piece : this.pieces) {
			board[piece.getLocation()] = piece;
		}
		return board;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return this.pieces;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		return this.moveablePieces;
	}

	public int getPlayerStartLoc() {
		return this.playerStartLoc;
	}
}
