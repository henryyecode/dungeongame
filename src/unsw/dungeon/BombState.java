package unsw.dungeon;

public interface BombState {
	int next(PlacedBomb bomb);
	boolean placed();
}
