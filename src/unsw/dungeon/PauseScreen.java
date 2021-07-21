package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PauseScreen {
	
	
    private static Stage stage;
    private static String title;
    private PauseController controller;
    private static Scene scene;

    public PauseScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "Pause Screen";

        controller = new PauseController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseView.fxml"));
        loader.setController(controller);

        // load into a Parent node called root
        Parent root = loader.load();
        scene = new Scene(root);
    }

    public static void start() throws IOException {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public PauseController getController() {
        return controller;
    }
}
