package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InstructionController {
	
	@FXML
	private Button menuButton;

	@FXML
	private MenuScreen menu;

	@FXML
	public void handleMenu(ActionEvent event) throws IOException {
		menu.start();
	}

	public void setMenuScreen(MenuScreen menu) {
		this.menu = menu;
	}

}