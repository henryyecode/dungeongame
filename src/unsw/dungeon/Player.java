package unsw.dungeon;

import java.util.ArrayList;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity implements PlayerSubject {
	
    private Dungeon dungeon;
    private Inventory inventory;
	public VincibilityState state;
	public int InvincibilityTime = 10;
	public final int invincibilityLength = 1000;
	public ArrayList<Enemy> enemies;
	public GoalComponent goal;
	public boolean alive;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.inventory = new Inventory(new ArrayList<Item>());
		this.state = new VincibleState();
		this.goal = dungeon.getGoal();
		this.alive = true;
    }

    public VincibilityState getState() {
		return state;
	}
    
    public VincibilityState turnVincible() {
		return state.turnVincible();
	}
	
	public VincibilityState turnInvincible() {
		return state.turnInvincible();
	}

	@Override
	public void updateEntity() {
		invincibilityTimer();
	}
	
	@Override
	public boolean killedByBomb() {
		setAlive(false);
		return true;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean canMove(int x, int y, String direction) {
    	Terrain terrain = dungeon.returnTerrain(x, y);
        if ((terrain == null) || terrain.canCross(x, y, direction, inventory)) {
        	return true;
        }
        return false;
    }
	
	public void activatePotion() {
    	for (Item I : inventory.getInventory()) {
    		if (I instanceof Potion) {
    			state = turnInvincible();
    			InvincibilityTime = this.invincibilityLength;
    			inventory.removeItem(I);;
    			return;
    		}
    	}
    }
	
	public void invincibilityTimer() {
		if (state instanceof InvincibleState) {
			int time = InvincibilityTime--;
			if (time == 0) 
				state = turnVincible();
		}
	}
    
    public void pickUpItem(int x, int y) {
    	Item item = dungeon.returnItem(x, y);
    	if (!(item == null)) {
    		if ((item instanceof Sword) && !(hasSword())) {
    			inventory.addItem(item);;
    			dungeon.removeEntity(item);
    			item.setVisible(false);
    			((Sword) item).equipSword();
    			return;
    		}
    		else if (!(item instanceof Sword)){
    			inventory.addItem(item);
    			dungeon.removeEntity(item);
    			item.setVisible(false);
    		}
    		//System.out.println(inventory.getInventory());
    	}
    }
    
    
    
    public void placeBomb() {
    	int flag = 0;
    	for (Item I : inventory.getInventory()) {
    		if (I instanceof Bomb) {
    			inventory.removeItem(I);;
    			dungeon.activateBomb();
    	    	return;
    		}
    	}
    	
    	
    	
    }
    
    public void moveUp() {
        if (!canMove(getX(), getY() - 1, "up")) {
        	return;
        }
        if (getY() > 0)
            y().set(getY() - 1);
    	
        pickUpItem(getX(), getY());
    }

    public void moveDown() {
    	if (!canMove(getX(), getY() + 1, "down")) {
        	return;
        }
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
        
        pickUpItem(getX(), getY());
    }
    
	public void moveLeft() {
    	if (!canMove(getX() - 1, getY(), "left")) {
        	return;
        }
    	if (getX() > 0)
            x().set(getX() - 1);
    	
    	pickUpItem(getX(), getY());
    }

    public void moveRight() {
    	if (!canMove(getX() + 1, getY(), "right")) {
        	return;
        }
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
        
        pickUpItem(getX(), getY());
    }

	@Override
	public void addEnemy(Enemy E) {
		enemies.add(E);
		
	}

	@Override
	public void removeEnemy(Enemy E) {
		enemies.remove(E);
	}

	@Override
	public void notifyEnemies() {
		for (Enemy E: enemies)
			E.update(this);
			
	}
	

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public boolean hasSword() {
		for (Item I : inventory.getInventory()) {
			if (I instanceof Sword) {
				return true;
			}
		}
		return false;
	}
	
	private void removeSword() {
		for (Item I : inventory.getInventory()) {
			if ((I instanceof Sword && ((Sword) I).durability == 0)) {
				inventory.removeItem(I);
				return;
			}
		}
	}

}


