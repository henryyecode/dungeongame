package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoseController {

	@FXML
	private Button newButton;
	
	@FXML
	private Button restartButton;
	
	@FXML
	private Button menuButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private LevelScreen level;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	public void handleNew(ActionEvent event) {
		dungeon.gameloop.stop();
		level.start();
	}
	
	@FXML
	public void handleRestart(ActionEvent event) throws IOException {
		dungeon.start();
	}
	@FXML
	public void handleMenu(ActionEvent event) {
		dungeon.gameloop.stop();
		menu.start();
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;	
	}
	
	

}