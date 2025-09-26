package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Webs;
import levelPieces.Zombie;

public class TestMovement {
	
	/*
	 * Tests Zombie's unique movement.
	 * 
	 * Need to test that movement:
	 *  - Walks towards the player.
	 *  - Doesn't ever walk beyond board boundaries.
	 *  - Doesn't move over other drawables.
	 */
	@Test
	public void testZombieMovement() {
		// Creating empty board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Zombie zombie = new Zombie(10);
		
		// Testing walking towards player:
		zombie.move(gameBoard, 0);
		assertEquals(zombie.getLocation(), 9);
		zombie.move(gameBoard, GameEngine.BOARD_SIZE);
		assertEquals(zombie.getLocation(), 10);
		
		// Testing staying within board bounds:
		//  - Attempting left direction past 0
		zombie.setLocation(0);
		zombie.move(gameBoard, -1);
		assertEquals(zombie.getLocation(), 0);
		//  - Attempting right direction past the max board size index
		zombie.setLocation(GameEngine.BOARD_SIZE-1);
		zombie.move(gameBoard, GameEngine.BOARD_SIZE); // Right
		assertEquals(zombie.getLocation(), GameEngine.BOARD_SIZE-1);
		
		// Testing moving over other drawables:
		zombie.setLocation(10);
		//  - Putting drawables on either side
		gameBoard[9] = new Webs();
		gameBoard[11] = new Webs();
		//  - Testing left movement
		zombie.move(gameBoard, 0);
		assertEquals(zombie.getLocation(), 10);
		//  - Testing right movement
		zombie.move(gameBoard, GameEngine.BOARD_SIZE);
		assertEquals(zombie.getLocation(), 10);
	}
	
	
}
