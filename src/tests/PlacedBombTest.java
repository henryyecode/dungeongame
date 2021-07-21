package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Boulder;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Enemy;
import unsw.dungeon.Entity;
import unsw.dungeon.LitStateExploded;
import unsw.dungeon.PlacedBomb;
import unsw.dungeon.Player;
import unsw.dungeon.Terrain;
import unsw.dungeon.Wall;

class PlacedBombTest {

	@Test
	void playerCanPlaceBombInTheDungeon() {
		Dungeon dungeon = new Dungeon(3,3);
		Player player = new Player(dungeon, 0,0);
		player.placeBomb();
		assertTrue(dungeon.returnTerrain(0, 0) instanceof PlacedBomb);
	}
	
	@Test
	void whenPlayerMovesThreeTimesBombExplodes() {
		Dungeon dungeon = new Dungeon(6,6);
		Player player = new Player(dungeon, 1,1);
		player.placeBomb();
		for(int i = 0; i < 3; i ++) {
			player.moveDown();
		}
		PlacedBomb E = (PlacedBomb) dungeon.returnTerrain(1,1);
		assertTrue(E.getBombState() instanceof LitStateExploded);
	}
	
	@Test 
	void killsBouldersEnemiesPlayersIfNextToWhenExploded() {
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 2,2);
		Boulder boulder = new Boulder(dungeon, 2,1);
		Enemy enemy = new Enemy(dungeon, 3,2);
		Wall wall1 = new Wall(3,1);
		Wall wall2 = new Wall(3,4);
		Wall wall3 = new Wall(3,3);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		dungeon.addEntity(boulder);
		dungeon.addEntity(enemy);
		dungeon.addEntity(wall1);
		dungeon.addEntity(wall2);
		dungeon.addEntity(wall3);
		player.placeBomb();
		player.moveLeft();
		player.moveUp();
		player.moveDown();
	}

}
