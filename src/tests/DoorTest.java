package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import unsw.dungeon.Door;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Key;
import unsw.dungeon.OpenDoor;
import unsw.dungeon.Player;

class DoorTest {

	@Test
	void closedDoorShouldReturnFalseToCross() {
		
		Dungeon dungeon = new Dungeon(2,2);
		Door door = new Door(1,1);
		Player player = new Player(dungeon, 0, 1);
		dungeon.addEntity(door);
		assertFalse(player.canMove(1, 1, "down"));
	}
	 @Test
	 void openDoorShouldReturnTrueToCanMove() {
		 	Dungeon dungeon = new Dungeon(2,2);
			Door door = new Door(1,1);
			door.setDoorState(new OpenDoor());
			Player player = new Player(dungeon, 0, 1);
			dungeon.addEntity(door);
			assertTrue(player.canMove(1, 1, "down"));
	 }
	 
	 @Test 
	 void closedDoorCanBeOpenedIfPlayerHasKey() {
		 	Dungeon dungeon = new Dungeon(2,2);
			Door door = new Door(1,1);
			dungeon.addEntity(door);
			Player player = new Player(dungeon, 0, 1);
			Key key = new Key(0,0);
			dungeon.addEntity(key);
			player.pickUpItem(0,0);
			assertTrue(player.canMove(1, 1, "down"));
	 }

	 @Test 
	 void keyCanOnlyBeUsedOnOneDoor() {
		 	Dungeon dungeon = new Dungeon(3,3);
			Door door = new Door(1,1);
			Door door2 = new Door(1,2);
			dungeon.addEntity(door);
			dungeon.addEntity(door2);
			Player player = new Player(dungeon, 0, 1);
			Key key = new Key(0,0);
			dungeon.addEntity(key);
			player.pickUpItem(0,0);
			player.canMove(1, 1, "down");
			assertFalse(player.canMove(1,2,"left"));
	 }

}
