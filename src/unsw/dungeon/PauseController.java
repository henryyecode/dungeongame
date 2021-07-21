package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Screen;

public class PauseController {

	@FXML
	private Button resumeButton;
	
	@FXML
	private Button restartButton;
	
	@FXML
	private Button menuButton;
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;
	
	@FXML
	public void handleResume(ActionEvent event) throws IOException {
		dungeon.resume();
	}
	
	@FXML
	public void handleRestart(ActionEvent event) throws IOException {
		dungeon.start();
	}
	
	@FXML
	public void handleMenu(ActionEvent event) {
		menu.start();
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;
	}



}