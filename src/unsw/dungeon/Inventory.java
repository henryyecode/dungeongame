package unsw.dungeon;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Inventory {
	
	private ArrayList<Item> entities;
	private IntegerProperty numSword, numKey, numBomb, numPotion;

	
	public Inventory(ArrayList<Item> arrayList) {
		super();
		this.entities = arrayList;
		this.numBomb = new SimpleIntegerProperty(0);
		this.numSword = new SimpleIntegerProperty(0);
		this.numKey = new SimpleIntegerProperty(0);
		this.numPotion = new SimpleIntegerProperty(0);
	}
	
	public ArrayList<Item> getInventory() {
		return entities;
	}

	public IntegerProperty getNumSword() {
		return numSword;
	}

	public IntegerProperty getNumKey() {
		return numKey;
	}

	public IntegerProperty getNumBomb() {
		return numBomb;
	}

	public IntegerProperty getNumPotion() {
		return numPotion;
	}

	public void setEntities(ArrayList<Item> entities) {
		this.entities = entities;
	}

	public void addItem(Entity entity) {
		if(entity instanceof Sword) {
			numSword.set(numSword.get() + 1);
		}
		if(entity instanceof Key) {
			numKey.set(numKey.get() + 1);
		}
		if(entity instanceof Bomb) {
			numBomb.set(numBomb.get() + 1);
		}
		if(entity instanceof Potion) {
			numPotion.set(numPotion.get() + 1);
		}
        entities.add((Item) entity);
    }
	
	public void removeItem(Entity entity) {
		if(entity instanceof Sword) {
			numSword.set(numSword.get() - 1);
		}
		if(entity instanceof Key) {
			numKey.set(numKey.get() - 1);
		}
		if(entity instanceof Bomb) {
			numBomb.set(numBomb.get() - 1);
		}
		if(entity instanceof Potion) {
			numPotion.set(numPotion.get() - 1);
		}
        entities.remove(entity);
    }
	
	public boolean useKey() {
		boolean retval = false;
		for(Item i: entities) {
			if(i.getClass().equals(Key.class)) {
				retval = true;
				//System.out.println("opened Door");
				removeItem(i);
				break;
			}
		}
		return retval;
	}

	
}
