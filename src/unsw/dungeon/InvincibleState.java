package unsw.dungeon;

public class InvincibleState implements VincibilityState {

	@Override
	public VincibilityState turnVincible() {
		System.out.println("Invincibility Wore Off");
		return new VincibleState();
	}

	@Override
	public VincibilityState turnInvincible() {
		System.out.println("Invincibility Refreshed !!");
		return new InvincibleState();
	}

}
