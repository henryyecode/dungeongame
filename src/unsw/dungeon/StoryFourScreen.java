package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoryFourScreen {
	
    private static Stage stage;
    private static String title;
    private StoryFourController controller;
    private static Scene scene;

    public StoryFourScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "DOOM";

        controller = new StoryFourController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StoryFourView.fxml"));
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

    public StoryFourController getController() {
        return controller;
    }
}