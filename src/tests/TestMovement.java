package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.SpookySkeleton;
import levelPieces.Webs;
import levelPieces.Zombie;
/**
 * TestMovement class
 * Contains a set of tests that verify that the movement of each Piece is
 * behaving correctly.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/26/2025
 * Collaborators: N/A
 * Sources: N/A
 */
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
		zombie.setLocation(gameBoard, 0);
		zombie.move(gameBoard, -1);
		assertEquals(zombie.getLocation(), 0);
		//  - Attempting right direction past the max board size index
		zombie.setLocation(gameBoard, GameEngine.BOARD_SIZE-1);
		zombie.move(gameBoard, GameEngine.BOARD_SIZE); // Right
		assertEquals(zombie.getLocation(), GameEngine.BOARD_SIZE-1);
		
		// Testing moving over other drawables:
		zombie.setLocation(gameBoard, 10);
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
	
	/*
	 * Tests SpookySkeleton's random movement.
	 * 
	 * Need to test that movement:
	 *  - Is random in moving -2, -1, 0, 1, or 2 spaces.
	 *  - Doesn't ever move beyond board boundaries.
	 *  - Doesn't move onto other drawables.
	 */
	@Test
	public void testSpookySkeleton() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		SpookySkeleton skeleton = new SpookySkeleton(10);
		
		// Testing that the movement is random:
		int countLeftJump = 0;
		int countLeft = 0;
		int countStay = 0;
		int countRight = 0;
		int countRightJump = 0;
		for (int i = 0; i < 300; i++) {
			skeleton.setLocation(gameBoard, 10);
			skeleton.move(gameBoard, 0);
			int location = skeleton.getLocation();
//			System.out.println(location);
//			if (location < 8 || location > 12) {
//				fail("Invalid move detected!");
//			}
			if (location == 8) countLeftJump++;
			if (location == 9) countLeft++;
			if (location == 10) countStay++;
			if (location == 11) countRight++;
			if (location == 12) countRightJump++;
		}
		//  - Ensuring that each of the random options occurs at least once.
		assert(countLeftJump > 10);
		assert(countLeft > 10);
		assert(countStay > 10);
		assert(countRight > 10);
		assert(countRightJump > 10);
		
		// Testing that the movement stays within board boundaries:
		for (int i = 0; i < 300; i++) {
			// Checking left side.
			skeleton.setLocation(gameBoard, 0);
			skeleton.move(gameBoard, 0);
			assert(skeleton.getLocation() >= 0);
			// Checking right side.
			skeleton.setLocation(gameBoard, GameEngine.BOARD_SIZE-1);
			skeleton.move(gameBoard, 0);
			assert(skeleton.getLocation() < GameEngine.BOARD_SIZE);
		}
		
		// Testing that the movement doesn't go onto drawables:
		gameBoard[9] = new Webs();
		gameBoard[12] = new Webs();
		countLeft = 0;
		countRightJump = 0;
		for (int i = 0; i < 300; i++) {
			skeleton.setLocation(gameBoard, 10);
			skeleton.move(gameBoard, 0);
			int location = skeleton.getLocation();
			if (location == 9) countLeft++;
			if (location == 12) countRightJump++;
		}
		//  - Ensuring that the skeleton never lands on the drawables.
		assertEquals(countLeft, 0);
		assertEquals(countRightJump, 0);
	}
}
