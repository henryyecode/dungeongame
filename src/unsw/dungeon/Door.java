package unsw.dungeon;

public class Door extends Terrain {
	private DoorState doorState = new ClosedDoor();
	
	
	public Door(int x, int y) {
		super(x,y);
	}
	public DoorState getDoorState() {
		return doorState;
	}
	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
	}
	public void nextState() {
		doorState.next(this);
		//TODO notify the dungeon screen that the door has changed state and now needs to be the open door image
	}
	@Override
	public boolean canCross(int x, int y, String string, Inventory inventory) {
		if(doorState.isOpen() == false && inventory.useKey()) {
			this.nextState();
			this.setVisible(false);
		}
		return doorState.isOpen();
	}
	
	
}
