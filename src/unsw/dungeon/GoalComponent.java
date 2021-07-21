package unsw.dungeon;

import javafx.beans.property.StringProperty;

public interface GoalComponent {
	public boolean isComplete();
	public StringProperty goalName();
	public void changeGoalName(String string);
	public void addGoal(GoalComponent g);
}


