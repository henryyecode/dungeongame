package unsw.dungeon;

public class Wall extends Terrain {

    public Wall(int x, int y) {
        super(x, y);
    }

	@Override
	public boolean canCross(int x, int y, String string, Inventory inventory) {
		return false;
	}
    
}
