package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelScreen {
	private static Stage stage;
    private static String title;
    private LevelController controller;
    private static Scene scene;

    public LevelScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "Pick Your Level";

        controller = new LevelController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelView.fxml"));
        loader.setController(controller);

        // load into a Parent node called root
        Parent root = loader.load();
        scene = new Scene(root);
    }

    public static void start() {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public LevelController getController() {
        return controller;
    }

}