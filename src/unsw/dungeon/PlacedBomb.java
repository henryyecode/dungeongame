package unsw.dungeon;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PlacedBomb extends Terrain {
	private BombState bombState;
	private int bombCountDown;
	private Dungeon dungeon;
	private final int framesPerState = 50;
	private boolean placed;
	private IntegerProperty state;
	
	public PlacedBomb(int x, int y, Dungeon dungeon) {
		super(x, y);
		this.bombState = new LitState1();
		this.dungeon = dungeon;
		bombCountDown = 0;
		this.state = new SimpleIntegerProperty(-1);
	}
	
	public boolean isPlaced() {
		return placed;
	}

	public void setPlaced(boolean placed) {
		if(placed) {
			state.set(0);
			bombState = new LitState1();
		}
		this.placed = placed;
	}
	
	

	public IntegerProperty getState() {
		return state;
	}

	public void setState(IntegerProperty state) {
		this.state = state;
	}

	@Override
	public void updateEntity() {
		if(isPlaced()) {
			bombCountDown++;
			if(bombCountDown % framesPerState == 0) {	
				int countdown = bombState.next(this);
				state.set(countdown);
				//System.out.println("bombstate = " + this.getBombState());
				if(bombState instanceof LitStateExploded) {
					//TODO Fix the way the bomb kills
					if(countdown == 4) {
						x().set(0);
						y().set(0);
						this.placed = false;
						return;
					}
					Entity north = dungeon.returnEntity(Math.max(getX(), 0), Math.max(getY() - 1, 0));
					Entity south = dungeon.returnEntity(Math.max(getX(), 0), Math.max(getY() + 1, 0));
					Entity east = dungeon.returnEntity(Math.max(getX()+ 1, 0), Math.max(getY(), 0));
					Entity west = dungeon.returnEntity(Math.max(getX() - 1, 0), Math.max(getY(), 0));
					
					Lock lock = new ReentrantLock();
					lock.lock();
					if(north != null && north.killedByBomb()) {
					}
					if(south != null &&south.killedByBomb()) {
					}
					if(east != null &&east.killedByBomb()) {
					}
					if(west != null &&west.killedByBomb()) {
					}
					lock.unlock();
					
				}
			}
		}
	}

	public BombState getBombState() {
		return bombState;
	}



	public void setBombState(BombState bombState) {
		this.bombState = bombState;
	}



	@Override
	public boolean canCross(int x, int y, String string, Inventory inventory) {
		return true;
	}

	
	

}
