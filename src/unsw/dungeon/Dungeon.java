/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon {

    private int width, height;
    private List<Entity> entities;
    private Player player;
    private GoalComponent Goal;
    
    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
    }

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    public void removeEntity(Entity entity) {
    	entities.remove(entity);
    }

	public Terrain returnTerrain(int x, int y) {
		for (Entity E : entities) {
			if (E instanceof Terrain) {
				if ((E.getX() == x) && (E.getY() == y)) { 
					return (Terrain) E;
				}
			}
		}
		return null;
	}
	
	public Item returnItem(int x, int y) {
		for (Entity E : entities) {
			if ((E instanceof Potion) || (E instanceof Sword) || 
				(E instanceof Key) || (E instanceof Bomb) || (E instanceof Treasure)) {
				if ((E.getX() == x) && (E.getY() == y)) { 
					return (Item) E;
				}
			}
		}
		return null;
	}
	
	public Entity returnEntity(int x, int y ) {
		for (Entity E : entities) {
			//System.out.println("entite" + E.toString() + "@ " + E.getX() + " : " + E.getY());
			if ((E.getX() == x) && (E.getY() == y)) {
				return E;
			}
		}
		return null;
	}
	
	public void updateEntities() {
		for (Entity E : entities) {
			if(E!=null) {
				E.updateEntity();
			}
		}
	}
	
	public boolean allTreasuresCollected() {
		boolean flag = true;
		for (Entity E : entities) {
			if (E instanceof Treasure) {
				flag = false;
			}
		}
		return flag;
	}
	
	public boolean reachedExit() {
		for (Entity E : entities) {
			if (E instanceof Exit) {
				if (getPlayer().getX() == E.getX() && getPlayer().getY() == E.getY())
					return true;
			}
		}
		return false;
	}
	
	public boolean allEnemiesKilled() {
		boolean flag = true;
		for (Entity E : entities) {
			if (E instanceof Enemy && ((Enemy) E).isAlive()) {
				flag = false;
			}
		}
		return flag;
	}
	
	public boolean allFloorSwitchesOn() {
		boolean flag = true;
		for (Entity E : entities) {
			if (E instanceof FloorSwitch) {
				if (((FloorSwitch) E).getState() instanceof SwitchOff)
					flag = false;
			}
		}
		return flag;
	}
	

	public ArrayList<Enemy> getEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		for (Entity E : entities) {
			if (E instanceof Enemy) {
				if (!(enemies.contains(E)))
					enemies.add((Enemy) E);
			}
		}
		return enemies;
	}

	public GoalComponent getGoal() {
		return Goal;
	}

	public void setGoal(GoalComponent goal) {
		Goal = goal;
	}

	public boolean checkGoals() {
    	return this.getGoal().isComplete();
    }
	
	public void activateBomb() {
		for(Entity E: entities) {
			if(E instanceof PlacedBomb) {
				E.x().set(player.getX());
				E.y().set(player.getY());
				((PlacedBomb) E).setPlaced(true);
				return;
			}
		}
	}
	
}
