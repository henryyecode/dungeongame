package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Boulder;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.Treasure;
import unsw.dungeon.Wall;

class TreasureTest {
	
	Dungeon D = new Dungeon(4, 4);
	Player P = new Player(D, 1, 1);
	Treasure T1 = new Treasure(D, 1, 2);
	Treasure T2 = new Treasure(D, 1, 3);
	
	@Test
	void pickupTreasureSuccess() {
		D.addEntity(T1);
		P.moveDown();
		assert(!D.getEntities().contains(T1));
		assert(P.getInventory().getInventory().contains(T1));
	}
	
	@Test
	void pickup2TreasureSuccess() {
		D.addEntity(T1);
		D.addEntity(T2);
		P.moveDown();
		P.moveDown();
		assert(!D.getEntities().contains(T2));
		assert(P.getInventory().getInventory().contains(T2));
		assert(P.getInventory().getInventory().size() == 2);
	}
	

}
