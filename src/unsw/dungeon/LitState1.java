package unsw.dungeon;

public class LitState1 implements BombState {

	@Override
	public int next(PlacedBomb bomb) {
		bomb.setBombState(new LitState2());
		return 1;
	}

	@Override
	public boolean placed() {
		// TODO Auto-generated method stub
		return true;
	}

}
