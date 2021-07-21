package unsw.dungeon;

public class Treasure extends Item {
	
	private Dungeon dungeon;
	
	public Treasure(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
	}
	
}
