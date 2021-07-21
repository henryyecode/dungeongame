package unsw.dungeon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * A JavaFX controller for the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonController implements EventHandler<ActionEvent> {

    //private static PauseScreen  = null;

	@FXML
    private GridPane squares;
    
    @FXML
    private PauseScreen pause;
    
    @FXML
    private LevelScreen levels;
    
    @FXML
    private MenuScreen menu;
    
    @FXML
    private WinScreen win;
    
    @FXML
    private LoseScreen lose;
    
    @FXML
    private StoryOneScreen one;
    
    @FXML
    private StoryTwoScreen two;
    
    @FXML
    private StoryThreeScreen three;
    
    @FXML
    private StoryFourScreen four;
    
    @FXML
    private RightScreen right;
    
    @FXML
    private Button pauseb;
    
    @FXML
    private DungeonScreen dungeonscreen;

    private List<ImageView> initialEntities;

    private Player player;

    public Dungeon dungeon;

    

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.initialEntities = new ArrayList<>(initialEntities);
    }
    
    public void update() throws IOException {
    	dungeon.updateEntities();
    	if(dungeon.checkGoals()) {
    		if(dungeonscreen.story == 1) {
        		two.start();
        		return;
        	}
        	if(dungeonscreen.story == 2) {
        		three.start();
        		dungeonscreen.pause();
        		return;
        	}
        	if(dungeonscreen.story == 3) {
        		four.start();
        		dungeonscreen.pause();
        		return;
        	}
    		this.win.start();
    	}
    	if(!player.isAlive()) {
    		player.setAlive(true);
    		this.lose.start();
    	}
    }

    public Inventory getInventory() {
    	return player.getInventory();
    }
    
    @FXML
    public void initialize() {
        Image ground = new Image("/dirt_0_new.png");
        
        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);
        pauseb = new Button("pause");
        pauseb.setOnAction(this);
        squares.add(pauseb, dungeon.getWidth(), dungeon.getHeight() - 1);
        
    }
    
    @FXML
	public void handle(ActionEvent event) {
    	try {
			pause.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @FXML
    public void handleKeyPress(KeyEvent event) throws IOException {
        switch (event.getCode()) {
        case UP:
            player.moveUp();
            break;
        case DOWN:
            player.moveDown();
            break;
        case LEFT:
            player.moveLeft();
            break;
        case RIGHT:
            player.moveRight();
            break;
        case SPACE:
            player.activatePotion();
            break;
        case V:
            player.activatePotion();
            break;
        case B:
            player.placeBomb();
            break;
        case P:
        	dungeonscreen.pause();
        	pause.start();
        	break;
        case ESCAPE:
        	dungeonscreen.pause();
        	pause.start();
        	break;
        default:
            break;
        }
        if (dungeon.getGoal().isComplete()) {
        	if(dungeonscreen.isStory) {
	        	if(dungeonscreen.story == 1) {
	        		two.start();
	        		return;
	        	}
	        	if(dungeonscreen.story == 2) {
	        		three.start();
	        		return;
	        	}
        	}		
        this.win.start();
        	
        }
        if (player.alive == false) {
        	this.lose.start();
        }
        
    }

	public void setLevelScreen(LevelScreen levelScreen) {
		levels = levelScreen;
	}

	public void setPauseScreen(PauseScreen pauseScreen) {
		pause = pauseScreen;
	}

	public void setWinScreen(WinScreen winScreen) {
		win = winScreen;
	}

	public void setLoseScreen(LoseScreen loseScreen) {
		lose = loseScreen;
		
	}

	public void setStoryOneScreen(StoryOneScreen storyOneScreen) {
		one = storyOneScreen;
		
	}
	
	public void setStoryTwoScreen(StoryTwoScreen storyTwoScreen) {
		two = storyTwoScreen;
		
	}

	public void setStoryThreeScreen(StoryThreeScreen story3) {
		three = story3;
		
	}
	
	public void setStoryFourScreen(StoryFourScreen story4) {
		four = story4;
		
	}

	public void setRightScreen(RightScreen right) {
		this.right = right;
		
	}

	
}

