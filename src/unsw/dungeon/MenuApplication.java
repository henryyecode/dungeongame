package unsw.dungeon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		MenuScreen menuScreen = new MenuScreen(primaryStage);
		DungeonScreen dungeonScreen = new DungeonScreen(primaryStage);
	    LevelScreen levelScreen = new LevelScreen(primaryStage);
	    PauseScreen pauseScreen = new PauseScreen(primaryStage);
	    WinScreen winScreen = new WinScreen(primaryStage);
	    LoseScreen loseScreen = new LoseScreen(primaryStage);
	    StoryOneScreen story1 = new StoryOneScreen(primaryStage);
	    StoryTwoScreen story2 = new StoryTwoScreen(primaryStage);
	    StoryThreeScreen story3 = new StoryThreeScreen(primaryStage);
	    LeftScreen left = new LeftScreen(primaryStage);
	    RightScreen right = new RightScreen(primaryStage);
	    StoryFourScreen story4 = new StoryFourScreen(primaryStage);
	    InstructionScreen instructions = new InstructionScreen(primaryStage);
	    
	    
	    menuScreen.getController().setinstructionScreen(instructions);
	    instructions.getController().setMenuScreen(menuScreen);
	    levelScreen.getController().setDungeonScreen(dungeonScreen);
	    menuScreen.getController().setDungeonScreen(dungeonScreen);
	    dungeonScreen.getController().setLevelScreen(levelScreen);
	    dungeonScreen.getController().setPauseScreen(pauseScreen);
	    pauseScreen.getController().setDungeonScreen(dungeonScreen);
	    dungeonScreen.getController().setWinScreen(winScreen);
	    dungeonScreen.getController().setLoseScreen(loseScreen);
	    winScreen.getController().setDungeonScreen(dungeonScreen);
	    loseScreen.getController().setDungeonScreen(dungeonScreen);
	    dungeonScreen.getController().setStoryOneScreen(story1);
	    dungeonScreen.getController().setStoryTwoScreen(story2);
	    dungeonScreen.getController().setStoryThreeScreen(story3);
	    dungeonScreen.getController().setStoryFourScreen(story4);
	    dungeonScreen.getController().setRightScreen(right);
	    story1.getController().setDungeonScreen(dungeonScreen);
	    story2.getController().setDungeonScreen(dungeonScreen);
	    story3.getController().setDungeonScreen(dungeonScreen);
	    story4.getController().setDungeonScreen(dungeonScreen);
	    right.getController().setDungeonScreen(dungeonScreen);
	    
		MenuScreen.start();
	    
		}

	    public static void main(String[] args) {
	        launch(args);
	    }
		
	}
	

