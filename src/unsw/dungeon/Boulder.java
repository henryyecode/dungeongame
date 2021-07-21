package unsw.dungeon;

public class Boulder extends Terrain {
	
	private volatile Dungeon dungeon;
	private boolean canMoveThrough;
	
	public Boulder(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		this.canMoveThrough = false;
	}
	public void joinSwitch(int x, int y) {
		Entity E = dungeon.returnEntity(x, y);
		if (E instanceof FloorSwitch) {
			((FloorSwitch) E).activateSwitchState();
		}
	}
	public void leaveSwitch(int x, int y) {
		Entity E = dungeon.returnEntity(x, y);
		if (E instanceof FloorSwitch) {
			((FloorSwitch) E).deactivateSwitchState();
		}
	}
	
	@Override
    public boolean killedByBomb() {
		this.setVisible(false);
		this.canMoveThrough = true;
    	return true;
    }

	
	@Override
	public boolean canCross(int x, int y, String string, Inventory inventory) {
		if (string == "up") {
			if (dungeon.returnTerrain(x, y - 1) == null) {
				
				joinSwitch(x, y - 1);
				y().set(getY() - 1);
				leaveSwitch(x, y);
				
				return true;
			}
		}	
    	if (string == "down") {
			if (dungeon.returnTerrain(x, y + 1) == null) {
				
				joinSwitch(x, y + 1);
				y().set(getY() + 1);
				leaveSwitch(x, y);
				
				return true;
			}
    	}
    	if (string == "left") {
    		if (dungeon.returnTerrain(x - 1, y) == null) {
				
    			joinSwitch(x - 1, y);
    			x().set(getX() - 1);
    			leaveSwitch(x, y);
    			
				return true;
			}
    	}
    	if (string == "right") {
    		if (dungeon.returnTerrain(x + 1, y) == null) {
				
    			joinSwitch(x + 1, y);
    			x().set(getX() + 1);
    			leaveSwitch(x, y);
    			
				
    			return true;
			}
    	}
		return canMoveThrough;
	}
	
	
}
