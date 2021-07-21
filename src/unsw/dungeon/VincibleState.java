package unsw.dungeon;

public class VincibleState implements VincibilityState {

	@Override
	public VincibilityState turnVincible() {
		System.out.println("Shouldnt really come here");
		return new VincibleState();
	}

	@Override
	public VincibilityState turnInvincible() {
		System.out.println("You are now Invincible !!");
		return new InvincibleState();
	}
	

}
