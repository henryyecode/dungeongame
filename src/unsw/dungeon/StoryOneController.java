package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StoryOneController {

	@FXML
	private Button nextButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	public void handleNext(ActionEvent event) throws IOException {
		dungeon.setJSON("maze");
		dungeon.isStory = true;
		dungeon.story(1);
		return;
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;	
	}
}