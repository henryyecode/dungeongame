package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import unsw.dungeon.Door;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Exit;
import unsw.dungeon.Key;
import unsw.dungeon.OpenDoor;
import unsw.dungeon.Player;
import unsw.dungeon.Wall;

class ExitTest {
	
	Dungeon D = new Dungeon(4, 4);
	Exit E = new Exit(1, 2);
	

	@Test
	void ExitGenerationSuccess() {
		D.addEntity(E);
		assert(D.getEntities().contains(E));
	}

}