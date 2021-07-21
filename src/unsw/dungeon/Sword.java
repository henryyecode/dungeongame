package unsw.dungeon;

public class Sword extends Item {
	
	private Dungeon dungeon;
	public SwordState state;
	public int durability;
		
	public Sword(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		this.state = new swordIntact();
		this.durability = 5;
	}
		public SwordState getState() {
			return state;
		}
		public SwordState newSword() {
			return state = state.newSword();
		}
		
		public SwordState swordBreak() {
			return state = state.swordBreak();
		}
		
		public void equipSword() {
			state.newSword();
		}
		public void reduceDurability() {
			durability--;
			if (durability == 0) {
				state = swordBreak();
			}
			
		}

}
