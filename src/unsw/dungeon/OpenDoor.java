package unsw.dungeon;

public class OpenDoor implements DoorState{

	@Override
	public void next(Door door) {
		return;
	}

	@Override
	public boolean isOpen() {
		return true;
	}
	
}
