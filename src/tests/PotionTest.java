package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Boulder;
import unsw.dungeon.Dungeon;
import unsw.dungeon.InvincibleState;
import unsw.dungeon.Player;
import unsw.dungeon.Potion;
import unsw.dungeon.VincibleState;
import unsw.dungeon.Wall;

class PotionTest {
	Dungeon D = new Dungeon(4, 4);
	Player P = new Player(D, 1, 1);
	Potion P1 = new Potion(D, 2, 1);
	Potion P2 = new Potion(D, 3, 1);
	
	
	
	@Test
	void usePotionSuccess() {
		D.addEntity(P1);
		P.moveRight();
		assert(!D.getEntities().contains(P1));
		assert(P.state instanceof InvincibleState);
	}
	
	@Test
	void PotionTimeOutSuccess() {
		D.addEntity(P1);
		P.moveRight();
		P.moveLeft();
		P.moveRight();
		P.moveLeft();
		P.moveRight();
		P.moveLeft();
		P.moveRight();
		P.moveLeft();
		P.moveRight();
		P.moveLeft();
		P.moveRight();
		assert(!D.getEntities().contains(P1));
		assert(P.state instanceof VincibleState);
	}
	
	@Test
	void PotionRefreshSuccess() {
		D.addEntity(P1);
		P.moveRight();
		P.moveLeft();
		P.moveRight();
		P.moveLeft();
		P.moveRight();
		P.moveLeft();
		assert(P.InvincibilityTime == 4);
		P.moveRight();
		D.addEntity(P2);
		P.moveRight();
		assert(P.InvincibilityTime == 9);
	}

}
