package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.AttackState;
import unsw.dungeon.Boulder;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Enemy;
import unsw.dungeon.Exit;
import unsw.dungeon.FloorSwitch;
import unsw.dungeon.Player;
import unsw.dungeon.Potion;
import unsw.dungeon.RunState;
import unsw.dungeon.Sword;
import unsw.dungeon.Treasure;
import unsw.dungeon.Wall;

class GoalsTest {

	Dungeon D = new Dungeon(5, 5);
	Treasure T = new Treasure(D, 1, 2);
	Player P = new Player(D, 1, 1);
	Enemy E = new Enemy(D, 0, 1);
	Sword S = new Sword(D, 2, 1);
	Boulder B = new Boulder(D, 3, 1);
	FloorSwitch F = new FloorSwitch(D, 4, 1);
	Exit Ex = new Exit(1, 3);
	
	@Test
	void ExitGoalSuccess() {
		D.addEntity(P);
		D.addEntity(Ex);
		P.moveDown();
		P.moveDown();
		P.goal = D.getGoal();
		assert(P.goal.isComplete());
	}
	
	@Test
	void TreasureGoalSuccess() {
		D.addEntity(T);
		P.moveDown();
		P.goal = D.getGoal();
		assert(P.goal.isComplete());
	}
	
	@Test
	void EnemyGoalSuccess() {
		D.addEntity(E);
		D.addEntity(S);
		P.moveRight();
		P.moveLeft();
		P.moveLeft();
		P.goal = D.getGoal();
		assert(P.goal.isComplete());
		
		
		
	}

	@Test
	void SwitchGoalSuccess() {
		P.moveRight();
		P.moveRight();
		P.moveRight();
		P.goal = D.getGoal();
		assert(P.goal.isComplete());
	}

}
