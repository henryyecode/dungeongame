package unsw.dungeon;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


public class GoalAnd implements GoalComponent {
	private String goal;
	private ArrayList<GoalComponent> children;
	private Dungeon dungeon;

	public GoalAnd(Dungeon dungeon, String goal) {
		this.dungeon = dungeon;
		this.goal = goal;
		this.children = new ArrayList<GoalComponent>();
	}
	
	@Override
	public boolean isComplete() {
		boolean flag = true;
		for (GoalComponent G : children) {
			if (!G.isComplete())
				flag = false;
		}
		return flag;
	}

	@Override
	public StringProperty goalName() {
		return new SimpleStringProperty("Complete ALL: ");
	}

	@Override
	public void addGoal(GoalComponent g) {
		children.add(g);
	}

	public ArrayList<GoalComponent> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<GoalComponent> children) {
		this.children = children;
	}

	@Override
	public void changeGoalName(String string) {
	}

	
}

