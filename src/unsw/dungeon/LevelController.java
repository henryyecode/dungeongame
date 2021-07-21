package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LevelController {

	@FXML
	private Button mazeButton;
	
	@FXML
	private Button bouldersButton;
	
	@FXML
	private Button advancedButton;
	
	@FXML
	private Button menuButton;
	
	@FXML
	private Button doorButton;
	
	
	@FXML
	private MenuScreen menu;
	
	@FXML
	private DungeonScreen dungeon;
	
	
	
	@FXML
	public void handleMaze(ActionEvent event) throws IOException {
		dungeon.setJSON("maze");
		dungeon.start();
	}
	
	@FXML
	public void handleBoulders(ActionEvent event) throws IOException {
		dungeon.setJSON("boulders");
		dungeon.start();
	}
	
	
	@FXML
	public void handleAdvanced(ActionEvent event) throws IOException {
		dungeon.setJSON("advanced");
		dungeon.start();
	}
	
	@FXML
	public void handleDoors(ActionEvent event) throws IOException {
		dungeon.setJSON("DoorandKey");
		dungeon.start();
	}
	
	@FXML
	public void handleMenu(ActionEvent event) throws IOException {
		menu.start();
	}

	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		dungeon = dungeonScreen;
	}
	
	public DungeonScreen getDungeonScreen() {
		return dungeon;
	}
}