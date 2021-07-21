package unsw.dungeon;

public class ClosedDoor implements DoorState {


	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public void next(Door door) {
		
		door.setDoorState(new OpenDoor());
		return;
	}

}
