package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StoryThreeController {

	@FXML
	private Button leftButton;
	
	@FXML
	private Button rightButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	private LeftScreen left;
	
	@FXML
	private RightScreen right;
	
	
	@FXML
	public void handleLeft(ActionEvent event) throws IOException {
		left.start();
		return;
	}
	
	@FXML
	public void handleRight(ActionEvent event) throws IOException {
		right.start();
		return;
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;
	}
	
}
