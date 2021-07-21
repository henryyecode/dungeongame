package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LeftController {

	@FXML
	private Button nextButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	private StoryOneScreen one;
	
	
	
	@FXML
	public void handleNext(ActionEvent event) throws IOException {
		one.start();
		return;
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;
	}
	
}