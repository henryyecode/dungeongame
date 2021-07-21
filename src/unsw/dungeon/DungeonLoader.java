package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;
    private ArrayList<GoalComponent> goals = new ArrayList<GoalComponent>();

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
        
        JSONObject jsonGoals = json.getJSONObject("goal-condition");
        dungeon.setGoal(loadGoal(dungeon, jsonGoals));
        return dungeon;
    }
    private GoalComponent loadGoal(Dungeon dungeon, JSONObject json) {
    	
    	String type = json.getString("goal");
    	GoalComponent goal = null;
    	switch (type) {
    	case "exit":
    		goal = new ExitGoal(dungeon, "exit");
    		goals.add(goal);
    		return goal;
    	
    	case "enemies":
    		goal = new EnemyGoal(dungeon, "enemies");
    		goals.add(goal);
    		return goal;
    	
    	case "treasure":
    		goal = new TreasureGoal(dungeon, "treasure");
    		goals.add(goal);
    		return goal;
    		
    	case "boulders":
    		goal = new SwitchGoal(dungeon, "boulders");
    		goals.add(goal);
    		return goal;
    		
    	case "AND":
    		goal = new GoalAnd(dungeon, "AND");
    		goals.add(goal);
    		addtoGoal(goal, json.getJSONArray("subgoals"), dungeon);
    		return goal;
    	case "OR":
    		goal = new GoalOr(dungeon, "OR");
    		goals.add(goal);
    		addtoGoal(goal, json.getJSONArray("subgoals"), dungeon);
    		return goal;
    	}
    	return null;
    }



	private void addtoGoal(GoalComponent goal, JSONArray jsonArray, Dungeon dungeon) {
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject J = jsonArray.getJSONObject(i);
			String help = J.getString("goal");
			switch (help) {
	    	case "exit":
	    		GoalComponent exit = new ExitGoal(dungeon, "exit");
	    		goal.addGoal(exit);
	    		goals.add(exit);
	    		break;
	    	case "enemies":
	    		GoalComponent enemies = new EnemyGoal(dungeon, "enemies");
	    		goal.addGoal(enemies);
	    		goals.add(enemies);
	    		break;
	    	case "treasure":
	    		GoalComponent treasure = new TreasureGoal(dungeon, "treasure");
	    		goal.addGoal(treasure);
	    		goals.add(treasure);
	    		break;
	    	case "boulders":
	    		GoalComponent boulders = new SwitchGoal(dungeon, "boulders");
	    		goal.addGoal(boulders);
	    		goals.add(boulders);
	    		break;
	    	case "AND":
	    		GoalComponent And = new GoalAnd(dungeon, "AND");
	    		addtoGoal(And, J.getJSONArray("subgoals"), dungeon);
	    		goal.addGoal(And);
	    	case "OR":
	    		GoalComponent Or = new GoalOr(dungeon, "OR");
	    		addtoGoal(Or, J.getJSONArray("subgoals"), dungeon);
	    		goal.addGoal(Or);
	    	}
		}
	}

	private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y);
            onLoad(wall);
            entity = wall;
            break;
        case "boulder":
        	Boulder boulder = new Boulder(dungeon, x, y);
        	onLoad(boulder);
        	entity = boulder;
        	break;
        case "switch":
        	FloorSwitch floorswitch = new FloorSwitch(dungeon, x, y);
        	onLoad(floorswitch);
        	entity = floorswitch;
        	break;
        case "invincibility":
        	Potion potion = new Potion(dungeon, x, y);
        	onLoad(potion);
        	entity = potion;
        	break;
        case "sword":
        	Sword sword = new Sword(dungeon, x, y);
        	onLoad(sword);
        	entity = sword;
        	break;
        case "bomb":
        	Bomb bomb = new Bomb(dungeon, x, y);
        	PlacedBomb placedBomb = new PlacedBomb(x, y, dungeon);
        	onLoad(bomb);
        	onLoad(placedBomb);
        	dungeon.addEntity(placedBomb);
        	entity = bomb;
        	break;
        case "treasure":
        	Treasure treasure = new Treasure(dungeon, x, y);
        	onLoad(treasure);
        	entity = treasure;
        	break;
        case "key":
        	Key key = new Key(x, y);
        	onLoad(key);
        	entity = key;
        	break;
        case "enemy":
        	Enemy enemy = new Enemy(dungeon, x, y);
        	onLoad(enemy);
        	entity = enemy;
        	break;
        case "exit":
        	Exit exit = new Exit(x, y);
        	onLoad(exit);
        	entity = exit;
        	break;
        case "door":
        	Door door = new Door(x, y);
        	onLoad(door);
        	entity = door;
        	break;
        
        // TODO Handle other possible entities
        }
        dungeon.addEntity(entity);
    }
	public ArrayList<GoalComponent> getGoalsArray() {
		return goals;
	}

    public abstract void onLoad(Entity player);

    public abstract void onLoad(Wall wall);

	public abstract void onLoad(Boulder boulder);

	public abstract void onLoad(FloorSwitch floorswitch);
	
	public abstract void onLoad(Sword sword);
	
	public abstract void onLoad(Potion potion);
	
	public abstract void onLoad(Treasure treasure);
	
	public abstract void onLoad(Key key);

	public abstract void onLoad(Bomb bomb);

	public abstract void onLoad(Enemy enemy);

	public abstract void onLoad(Exit exit);
	
	public abstract void onLoad(Door door);

	public abstract void onLoad(PlacedBomb placedBomb);
	

    // TODO Create additional abstract methods for the other entities

}
