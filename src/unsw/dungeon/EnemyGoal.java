package unsw.dungeon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EnemyGoal extends GoalSimple {
	
	public EnemyGoal(Dungeon dungeon, String goal) {
		super(dungeon, goal);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isComplete() {
		if (dungeon.allEnemiesKilled()) {
			changeGoalName("All Enemies Killed");
			return true;
		}
		return false;
	}

	@Override
	public StringProperty goalName() {
		StringProperty ret = super.goalName();
		ret.setValue("Kill All Enemies");
		return ret;
	}
	
	

}
