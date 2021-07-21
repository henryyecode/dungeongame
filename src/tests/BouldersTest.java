package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import unsw.dungeon.Boulder;
import unsw.dungeon.Door;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Key;
import unsw.dungeon.OpenDoor;
import unsw.dungeon.Player;
import unsw.dungeon.Wall;

class BouldersTest {
	Dungeon D = new Dungeon(4, 4);
	Player P = new Player(D, 1, 2);
	Boulder B1 = new Boulder (D, 2, 2);
	Boulder B2 = new Boulder (D, 3, 2);
	Boulder B3 = new Boulder (D, 1, 3);
	Boulder B4 = new Boulder (D, 1, 1);
	Wall W = new Wall (1, 0);
	
	
	@Test
	void moveBoulderSuccess() {
		D.addEntity(B3);
		P.moveDown();
		assert(B3.getY() == 4);
		assert(P.getY() == 3);
	}
	
	@Test
	void moveBoulderFailWall() {
		D.addEntity(B4);
		D.addEntity(W);
		P.moveUp();
		assert(B4.getY() == 1);
		assert(P.getY() == 2);
	}
	
	@Test
	void moveBoulderFailStackedBoulders() {
		D.addEntity(B1);
		D.addEntity(B2);
		P.moveRight();
		assert(B1.getX() == 2);
		assert(B2.getX() == 3);
		assert(P.getY() == 2);
	}

}
