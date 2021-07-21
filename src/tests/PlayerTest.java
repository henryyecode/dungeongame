package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import unsw.dungeon.Door;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Key;
import unsw.dungeon.OpenDoor;
import unsw.dungeon.Player;
import unsw.dungeon.Treasure;
import unsw.dungeon.Wall;

class PlayerTest {

	Dungeon D = new Dungeon(4, 4);
	Player P = new Player(D, 1, 1);
	Wall W1 = new Wall(1, 0);
	Wall W2 = new Wall(0, 1);
	Wall W3 = new Wall(1, 2);
	Wall W4 = new Wall(2, 1);
	
	@Test
	void moveUpSuccess() {
		P.moveUp();
		assert(P.getY() == 0);
	}
	
	@Test
	void moveDownSuccess() {
		P.moveDown();
		assert(P.getY() == 2);
	}
	
	@Test
	void moveLeftSuccess() {
		P.moveLeft();
		assert(P.getX() == 0);
	}
	
	@Test
	void moveRightSuccess() {
		P.moveRight();
		assert(P.getX() == 2);
	}
	
	@Test
	void moveUpFail() {
		D.addEntity(W1);
		P.moveUp();
		assert(P.getY() == 1);
	}
	
	@Test
	void moveDownFail() {
		D.addEntity(W3);
		P.moveDown();
		assert(P.getY() == 1);
	}
	
	@Test
	void moveLeftFail() {
		D.addEntity(W2);
		P.moveLeft();
		assert(P.getX() == 1);
	}
	
	@Test
	void moveRightFail() {
		D.addEntity(W4);
		P.moveRight();
		assert(P.getX() == 1);
	}
	
}
