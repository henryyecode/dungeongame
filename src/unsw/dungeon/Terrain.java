package unsw.dungeon;

public abstract class Terrain extends Entity {
	
	public Terrain(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public abstract boolean canCross(int x, int y, String string, Inventory inventory);
	
	
}
