package unsw.dungeon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SwitchGoal extends GoalSimple {
	
	public SwitchGoal(Dungeon dungeon, String goal) {
		super(dungeon, goal);
	}
	
	public boolean isComplete() {
		if (dungeon.allFloorSwitchesOn()) {
			changeGoalName("Switches Activated");
			return true;
		}
		changeGoalName("Activate all Switches");	
		return false;
	}

	@Override
	public StringProperty goalName() {
		StringProperty ret = super.goalName();
		ret.setValue("Activate all Switches");
		return ret;
	}
	

}
