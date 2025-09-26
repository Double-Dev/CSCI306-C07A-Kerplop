package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Ghost;
import levelPieces.JackOLantern;
import levelPieces.Spikes;
import levelPieces.SpookySkeleton;
import levelPieces.Witch;
import levelPieces.Zombie;
/**
 * TestInteractions class
 * Contains a set of tests that verify that the interaction of each Piece is
 * behaving correctly.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/26/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class TestInteractions {
	/*
	 * Tests ContactDamagePiece, used by Spikes, SpookySkeleton, and Zombie
	 * Should output a HIT when the player is on the same location.
	 */
	@Test
	public void testContactDamageInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Zombie zombie = new Zombie(10);
		assertEquals(zombie.interact(gameBoard, 9), InteractionResult.NONE);
		assertEquals(zombie.interact(gameBoard, 10), InteractionResult.HIT);
		
		Spikes spikes = new Spikes(10);
		assertEquals(spikes.interact(gameBoard, 9), InteractionResult.NONE);
		assertEquals(spikes.interact(gameBoard, 10), InteractionResult.HIT);
	}
	
	/*
	 * Tests Ghost Interaction
	 * Should output a KILL when the player is on the same location.
	 */
	@Test
	public void testGhostInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost ghost = new Ghost(10);
		assertEquals(ghost.interact(gameBoard, 9), InteractionResult.NONE);
		assertEquals(ghost.interact(gameBoard, 10), InteractionResult.KILL);
	}
	
	/*
	 * Tests JackOLantern Interaction
	 *  - Get a point when player is on the same space as a JackOLantern
	 *  - Player should only get 1 point per interaction with JackOLantern
	 *  - JackOLantern's symbol should change to ' ' after interaction
	 */
	@Test
	public void testJackOLanternInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		JackOLantern lantern = new JackOLantern(10);
		assertEquals(lantern.interact(gameBoard, 9), InteractionResult.NONE);
		assertEquals(lantern.interact(gameBoard, 10), InteractionResult.GET_POINT);
		assertEquals(lantern.getSymbol(), ' ');
		assertEquals(lantern.interact(gameBoard, 10), InteractionResult.NONE);
	}
	
	/*
	 * Tests Witch Interaction
	 * Should output a HIT when the player is 2 spaces in front of the Witch and only then.
	 */
	@Test
	public void testWitchInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Witch witch = new Witch(10);
		assertEquals(witch.interact(gameBoard, 8), InteractionResult.HIT);
		assertEquals(witch.interact(gameBoard, 10), InteractionResult.NONE);
	}
	
	/*
	 * Tests SpookySkeleton Interaction
	 * Should output a HIT when the player is on either side of it (but not 
	 * if they're on the same space).
	 */
	@Test
	public void testSkeletonInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		SpookySkeleton skeleton = new SpookySkeleton(10);
		assertEquals(skeleton.interact(gameBoard, 10), InteractionResult.NONE);
		assertEquals(skeleton.interact(gameBoard, 9), InteractionResult.HIT);
		assertEquals(skeleton.interact(gameBoard, 11), InteractionResult.HIT);
	}
}
