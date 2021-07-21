package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Enemy;
import unsw.dungeon.Player;
import unsw.dungeon.Sword;
import unsw.dungeon.Wall;
import unsw.dungeon.swordBroken;

class SwordTest {

	Dungeon D = new Dungeon(4, 4);
	Player P = new Player(D, 1, 1);
	Sword S1 = new Sword(D, 1, 0);
	Sword S2 = new Sword(D, 0, 1);
	Enemy E1 = new Enemy(D, 2, 1);
	Enemy E2 = new Enemy(D, 3, 1);
	Enemy E3 = new Enemy(D, 3, 2);
	Enemy E4 = new Enemy(D, 2, 2);
	Enemy E5 = new Enemy(D, 2, 3);
	
	
	
	@Test
	void pickUpSwordSuccess() {
		D.addEntity(S1);
		P.moveUp();
		assert(P.getInventory().getInventory().contains(S1));
		assert(P.getInventory().getInventory().size() == 1);	
	}
	@Test
	void pickUp2SwordsFail() {
		D.addEntity(S1);
		D.addEntity(S2);
		P.moveUp();
		P.moveDown();
		P.moveLeft();
		assert(!P.getInventory().getInventory().contains(S2));
		assert(P.getInventory().getInventory().size() == 1);	
	}
	
	@Test
	void killEnemySuccess() {
		D.addEntity(S1);
		D.addEntity(E1);
		P.moveUp();
		P.moveDown();
		P.moveRight();
		assert(!D.getEntities().contains(E1));	
	}
	@Test
	void DurabilitySuccess() {
		D.addEntity(S1);
		D.addEntity(E1);
		P.moveUp();
		P.moveDown();
		P.moveRight();
		D.addEntity(E2);
		P.moveRight();
		D.addEntity(E3);
		P.moveDown();
		D.addEntity(E4);
		P.moveLeft();
		D.addEntity(E5);
		P.moveDown();
		assert(S1.state instanceof swordBroken);
	}
	

}
