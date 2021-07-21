package unsw.dungeon;

public class Potion extends Item {
	
	private Dungeon dungeon;
	
	public Potion(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
	}

}
