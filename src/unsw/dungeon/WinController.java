package unsw.dungeon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WinController {

	@FXML
	private Button backButton;
	
	@FXML
	private MenuScreen menu;

	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	public void handleBack(ActionEvent event) {
		dungeon.gameloop.stop();
		menu.start();
	}
	
	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;
	}

}

