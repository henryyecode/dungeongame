package unsw.dungeon;

import java.lang.Math;

public class Enemy extends Entity implements EnemyObserver{
	private Dungeon dungeon;
	private EnemyState state; 
	private boolean alive;
	private int speed = 40;
	private int step;
	
	public Enemy(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		this.state = new AttackState();
		this.alive = true;
		this.step = 0;
	}
	
	@Override
    public boolean killedByBomb() {
		this.setAlive(false);
    	return true;
    }
    
	public void setAlive(boolean v) {
		this.alive = v;
		this.setVisible(v);
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public EnemyState getState() { 
		return state;
	}
    
    public EnemyState Run() {
    	this.speed = 10;
		return state = state.Run();
	}
	
	public EnemyState Attack() {
		this.speed = 40;
		return state =  state.Attack();
	}
	
	private void Move() {
		
		if (state instanceof RunState) {
			MoveAway(dungeon.getPlayer());
		}
		if (state instanceof AttackState) {
			MoveTowards(dungeon.getPlayer());
		}
	}
	
	private void MoveTowards(Player P) {
		String direction = direction(P);
		if (direction.equals("left")) 
				x().set(getX() + 1);
		if (direction.equals("right")) 
				x().set(getX() - 1);
		if (direction.equals("up")) 
				y().set(getY() + 1);
		if (direction.equals("down")) 
				y().set(getY() - 1);
	}

	private void MoveAway(Player P) {
		String direction = direction(P);
		if (direction.equals("left")) {
			if (dungeon.returnTerrain(getX() - 1, getY()) == null)
				x().set(getX() - 1);
		}
		if (direction.equals("right")) 
			if (dungeon.returnTerrain(getX() + 1, getY()) == null)	
				x().set(getX() + 1);
		if (direction.equals("up"))
			if (dungeon.returnTerrain(getX(), getY() - 1) == null)
				y().set(getY() - 1);
		if (direction.equals("down")) 
			if (dungeon.returnTerrain(getX(), getY() + 1) == null)
				y().set(getY() + 1);
	}
	
	public String direction(Player P) {
		if (P != null) {	
			int x1 = P.getX();
			int y1 = P.getY();
			int x2 = this.getX();
			int y2 = this.getY();
			int dist = java.lang.Math.abs(x1 - x2) + java.lang.Math.abs(y1 - y2);
			int newdist = java.lang.Math.abs(x1 - 1 - x2) + java.lang.Math.abs(y1 - y2);
			if ((newdist <= dist) && (dungeon.returnTerrain(getX() + 1, getY()) == null))
				return "left";
			newdist = java.lang.Math.abs(x1 + 1 - x2) + java.lang.Math.abs(y1 - y2);
			if ((newdist <= dist) && (dungeon.returnTerrain(getX() - 1, getY()) == null))
				return "right";
			newdist = java.lang.Math.abs(x1 - x2) + java.lang.Math.abs(y1 - 1 - y2);
			if ((newdist <= dist) && (dungeon.returnTerrain(getX(), getY() + 1) == null))
				return "up";
			newdist = java.lang.Math.abs(x1 - x2) + java.lang.Math.abs(y1 + 1 - y2);
			if ((newdist <= dist) && (dungeon.returnTerrain(getX(), getY() - 1) == null)) 
				return "down";
		}
		return "stay";
	}

	@Override
	public void updateEntity() {
		if(this.step == this.speed) {
			if (dungeon.getPlayer().getState() instanceof VincibleState)
				Attack();
			else
				Run();
			Move();
			
			step = 0;
		} else {
			this.step += 1;
		}
		this.interactPlayer();
	}

	@Override
	public void update(Player p) {
		// TODO Auto-generated method stub
		
	}

	public void interactPlayer() {
		if (dungeon.getPlayer().getX() == this.getX() && dungeon.getPlayer().getY() == this.getY()) {
			int flag = 0;
			if(dungeon.getPlayer().hasSword()) {
				flag = 1;
				this.setAlive(false);
				//dungeon.removeEntity(this);
			}
			if (dungeon.getPlayer().state instanceof InvincibleState) {
				flag = 1;
				this.setAlive(false);
				//dungeon.removeEntity(this);
			}
			if (flag == 0) {
				
				dungeon.getPlayer().setAlive(false);
			}
		}
	}
	
	
}
