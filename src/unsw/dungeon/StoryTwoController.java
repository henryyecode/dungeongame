package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StoryTwoController {

	@FXML
	private Button nextButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	public void handleNext(ActionEvent event) throws IOException {
		dungeon.setJSON("boulders");
		dungeon.story(2);
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;	
	}
}