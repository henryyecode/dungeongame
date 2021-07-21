package unsw.dungeon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExitGoal extends GoalSimple {
	
	public ExitGoal(Dungeon dungeon, String goal) {
		super(dungeon, goal);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isComplete() {
		if (dungeon.reachedExit()) {
			changeGoalName("Exit Reached");
			return true;
		}	
		return false;
	}

	@Override
	public StringProperty goalName() {
		StringProperty ret = super.goalName();
		ret.setValue("Reach The Exit");
		return ret;
	}
	


}
