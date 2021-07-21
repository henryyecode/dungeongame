package unsw.dungeon;

public class LitState3 implements BombState {

	@Override
	public int next(PlacedBomb bomb) {
		bomb.setBombState(new LitStateExploded());
		return 3;
	}

	@Override
	public boolean placed() {
		// TODO Auto-generated method stub
		return true;
	}

}
