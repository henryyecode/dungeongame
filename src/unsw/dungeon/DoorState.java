package unsw.dungeon;

public interface DoorState {
	void next(Door door);
	boolean isOpen();
}
