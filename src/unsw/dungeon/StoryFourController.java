package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StoryFourController {

	@FXML
	private Button nextButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;

	@FXML
	private RightScreen right;
	
	@FXML
	public void handleNext(ActionEvent event) throws IOException {
		dungeon.setJSON("DoorandKey");
		dungeon.story(4);
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;
	}
	
}

