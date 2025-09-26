package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.JackOLantern;
import levelPieces.Zombie;

public class TestInteraction {
	/*
	 * Tests ContactDamagePiece, used by Spikes, SpookySkeleton, and Zombie
	 * Should output a HIT when the player is on the same location.
	 */
	@Test
	public void testContactDamageInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Using Zombie as arbitrary non-abstract child to test this.
		Zombie zombie = new Zombie(10);
		assertEquals(zombie.interact(gameBoard, 10), InteractionResult.HIT);
	}
	
	/*
	 * Tests JackOLantern Interaction
	 *  - Get a point when player is on the same space as a JackOLantern
	 *  - Player should only get 1 point per interaction with JackOLantern
	 */
	@Test
	public void testJackOLanternInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		JackOLantern lantern = new JackOLantern(10);
		assertEquals(lantern.interact(gameBoard, 10), InteractionResult.GET_POINT);
		assertEquals(lantern.interact(gameBoard, 10), InteractionResult.NONE);
	}
}
