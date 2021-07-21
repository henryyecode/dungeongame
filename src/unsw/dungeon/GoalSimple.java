package unsw.dungeon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GoalSimple implements GoalComponent {

	private StringProperty goal;
	public Dungeon dungeon;
	
	public GoalSimple(Dungeon dungeon, String goal) {
		this.dungeon = dungeon;
		this.goal = new SimpleStringProperty(goal);
	}
	
	@Override
	public boolean isComplete() {
		return false;
	}

	@Override
	public StringProperty goalName() {
		return goal;
	}
	
	

	@Override
	public void addGoal(GoalComponent g) {
		return;
	}

	@Override
	public void changeGoalName(String string) {
		goal.set(string);
	}
}
