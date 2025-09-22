package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

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
		case 1:
			// TODO: Level 1 design.
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
