package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

	@FXML
	private Button storyButton;
	
	@FXML
	private Button levelButton;
	
	@FXML
	private Button instructButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private InstructionScreen instruction;
	
	@FXML
	private StoryOneScreen one;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	private LevelScreen level;

	@FXML
	public void handleStory(ActionEvent event) throws IOException {
		one.start();
	}
	
	@FXML
	public void handleLevel(ActionEvent event) {
		level.start();
	}
	
	@FXML
	public void handleInstruct(ActionEvent event) {
		instruction.start();
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;	
	}

	public void setinstructionScreen(InstructionScreen instructions) {
		instruction = instructions;
	}
}