package unsw.dungeon;

public class swordIntact implements SwordState {

	@Override
	public SwordState newSword() {
		System.out.println("new Sword Equipped !!");
		return new swordIntact();
	}

	@Override
	public SwordState swordBreak() {
		System.out.println("Sword Broken !!");
		return new swordBroken();
	}

}
