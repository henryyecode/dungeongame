package unsw.dungeon;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GoalOr implements GoalComponent {

	private StringProperty goal;
	private ArrayList<GoalComponent> children;
	private Dungeon dungeon;

	public GoalOr(Dungeon dungeon, String goal) {
		this.dungeon = dungeon;
		this.goal = new SimpleStringProperty(goal);
		this.children = new ArrayList<GoalComponent>();
	}
	
	public StringProperty getGoal() {
		return new SimpleStringProperty("Complete ONE ...");
	}


	public ArrayList<GoalComponent> getChildren() {
		return children;
	}

	@Override
	public boolean isComplete() {
		for (GoalComponent G: children) {
			if (G.isComplete())
				return true;
		}
		return false;
	}

	@Override
	public StringProperty goalName() {
		return goal;
	}

	@Override
	public void addGoal(GoalComponent g) {
		children.add(g);
	}

	@Override
	public void changeGoalName(String string) {
		// TODO Auto-generated method stub
		
	}
}
