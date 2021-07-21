package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RightController {

	@FXML
	private Button nextButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	private StoryThreeScreen three;
	
	
	@FXML
	public void handleNext(ActionEvent event) throws IOException {
		dungeon.setJSON("advanced");
		dungeon.story(3);
		return;
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;
	}
	
}