package unsw.dungeon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;

    //Images
    private Image playerImage;
    private Image wallImage;
    private Image boulderImage;
    private Image switchImage;
    private Image swordImage;
    private Image treasureImage;
    private Image bombImage;
    private Image keyImage;
    private Image potionImage;
    private Image enemyImage;
    private Image exitImage;
    private Image closedDoorImage;
    private Image openDoorImage;
    private Image lit1image;
    private Image lit2image;
    private Image lit3image;
    private Image lit4image;
    

    public DungeonControllerLoader(String filename)
            throws FileNotFoundException {
        super(filename);
        entities = new ArrayList<>();
        playerImage = new Image("/human_new.png");
        wallImage = new Image("/brick_brown_0.png");
        boulderImage = new Image("/boulder.png");
        switchImage = new Image("/pressure_plate.png");
        swordImage = new Image("/greatsword_1_new.png");
        treasureImage = new Image("/gold_pile.png");
        bombImage = new Image("/bomb_unlit.png");
        keyImage = new Image("/key.png");
        potionImage = new Image("/brilliant_blue_new.png");
        enemyImage = new Image("/deep_elf_master_archer.png");
        exitImage = new Image("/exit.png");
        closedDoorImage = new Image("/closed_door.png");
        openDoorImage = new Image("/open_door.png");
        lit1image = new Image("/bomb_lit_1.png");
        lit2image = new Image("/bomb_lit_2.png");
        lit3image = new Image("/bomb_lit_3.png");
        lit4image = new Image("/bomb_lit_4.png");
        
        
    }

    @Override
    public void onLoad(Entity player) {
        ImageView view = new ImageView(playerImage);
        trackVisible(player, view);
        addEntity(player, view);
    }

    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }
    
    @Override
    public void onLoad(Boulder boulder) {
        ImageView view = new ImageView(boulderImage);
        trackVisible(boulder, view);
        addEntity(boulder, view);
    }
    
    @Override
    public void onLoad(FloorSwitch floorswitch) {
        ImageView view = new ImageView(switchImage);
        addEntity(floorswitch, view);
    }
    
    @Override
    public void onLoad(Sword sword) {
        ImageView view = new ImageView(swordImage);
        trackVisible(sword, view);
        addEntity(sword, view);
    }

    @Override
    public void onLoad(Bomb bomb) {
        ImageView view = new ImageView(bombImage);
        trackVisible(bomb, view);
        addEntity(bomb, view);
    }
    
    @Override
    public void onLoad(Potion potion) {
        ImageView view = new ImageView(potionImage);
        trackVisible(potion, view);
        addEntity(potion, view);
    }
    
    @Override
    public void onLoad(Key key) {
        ImageView view = new ImageView(keyImage);
        trackVisible(key, view);
        addEntity(key, view);
    }
    
    @Override
    public void onLoad(Treasure treasure) {
        ImageView view = new ImageView(treasureImage);
        trackVisible(treasure, view);
        addEntity(treasure, view);
    }
    
    @Override
    public void onLoad(Enemy enemy) {
        ImageView view = new ImageView(enemyImage);
        trackVisible(enemy, view);
        addEntity(enemy, view);
    }
    
    @Override
    public void onLoad(Exit exit) {
        ImageView view = new ImageView(exitImage);
        addEntity(exit, view);
    }
    
    @Override
    public void onLoad(Door door) {
        ImageView closedDoor = new ImageView(closedDoorImage);
        ImageView openDoor = new ImageView(openDoorImage);
        addEntity(door, closedDoor);
        trackVisible(door, closedDoor);
        addEntity(door, openDoor);
    }
    
    @Override 
    public void onLoad(PlacedBomb placedBomb) {
    	ImageView[] litbombs = new ImageView[] {
    			new ImageView(lit1image), 
    			new ImageView(lit2image),
    			new ImageView(lit3image),
    			new ImageView(lit4image)
    	};
    	
    	trackBomb(placedBomb, litbombs);
    	for(ImageView i: litbombs) {
    		i.setVisible(false);
    		entities.add(i);
    	}
    }
    
    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        entities.add(view);
    }
    /**
     * Set a node in a GridPane to have its position track the position of an
     * entity in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the
     * model will automatically be reflected in the view.
     * @param entity
     * @param node
     */
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        entity.x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
            }
        });
        
    }
    
    private void trackVisible(Entity entity, Node node) {
    	entity.visible().addListener(new ChangeListener<Boolean>() {
        	@Override
        	public void changed(ObservableValue<? extends Boolean> observable,
        			Boolean oldValue, Boolean newValue) {
        		node.setVisible(entity.isVisible());
        	}
        });
    }
    
    private void trackBomb(PlacedBomb placedBomb, Node[] nodes) {
    	
        for(Node node: nodes) {
        	GridPane.setColumnIndex(node, 0);
        	GridPane.setRowIndex(node, 0);
	        placedBomb.x().addListener(new ChangeListener<Number>() {
	            @Override
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                GridPane.setColumnIndex(node, newValue.intValue());
	            }
	        });
	        placedBomb.y().addListener(new ChangeListener<Number>() {
	            @Override
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                GridPane.setRowIndex(node, newValue.intValue());
	            }
	        });
        }
    	placedBomb.getState().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> observable,
        			Number oldValue, Number newValue) {
        		switch(newValue.intValue()) {
        			case 0:
	        			nodes[0].setVisible(true);
	        			break;
        			case 1:
        				nodes[0].setVisible(false);
        				nodes[1].setVisible(true);
        				break;
        			case 2:
        				nodes[1].setVisible(false);
        				nodes[2].setVisible(true);
        				break;
        			case 3:
        				nodes[2].setVisible(false);
        				nodes[3].setVisible(true);
        				break;
        			case 4:
        				nodes[3].setVisible(false);
        			
        		}
        	}
        });
    	
    }

    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
        return new DungeonController(load(), entities);
    }


}
