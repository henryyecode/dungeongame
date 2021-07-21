package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoryOneScreen {

    private static Stage stage;
    private static String title;
    private StoryOneController controller;
    private static Scene scene;

    public StoryOneScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "A Start Of A New Adventure ...";

        controller = new StoryOneController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StoryOneView.fxml"));
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

    public StoryOneController getController() {
        return controller;
    }
}
