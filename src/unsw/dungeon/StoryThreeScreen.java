package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoryThreeScreen {
	
    private static Stage stage;
    private static String title;
    private StoryThreeController controller;
    private static Scene scene;

    public StoryThreeScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "Ouch !";

        controller = new StoryThreeController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StoryThreeView.fxml"));
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

    public StoryThreeController getController() {
        return controller;
    }
}