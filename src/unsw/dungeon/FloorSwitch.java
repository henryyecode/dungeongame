package unsw.dungeon;

public class FloorSwitch extends Entity {
	
	private Dungeon dungeon;
	public SwitchState state; 
	
	public FloorSwitch(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		this.state = new SwitchOff();
	}
	public SwitchState getState() {
		return state;
	}
	public SwitchState activateSwitchState() {
		return state = state.activateSwitchState();
	}
	
	public SwitchState deactivateSwitchState() {
		return state = state.deactivateSwitchState();
	}

	
	
}
