package unsw.dungeon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TreasureGoal extends GoalSimple {
	
	public TreasureGoal(Dungeon dungeon, String goal) {
		super(dungeon, goal);
	}
	
	public boolean isComplete() {

		if (dungeon.allTreasuresCollected()) {
			changeGoalName("Completed Treasure");
			return true;
		}
		return false;
	}

	@Override
	public StringProperty goalName() {
		StringProperty ret = super.goalName();
		ret.setValue("Collect All Treasure");
		return ret;
	}
	
	

	
	
	

}
