package unsw.dungeon;

public class LitState2 implements BombState {

	@Override
	public int next(PlacedBomb bomb) {
		bomb.setBombState(new LitState3());
		return 2;
	}

	@Override
	public boolean placed() {
		// TODO Auto-generated method stub
		return true;
	}

}
