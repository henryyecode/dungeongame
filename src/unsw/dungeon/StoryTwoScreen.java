package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoryTwoScreen {

    private static Stage stage;
    private static String title;
    private StoryTwoController controller;
    private static Scene scene;

    public StoryTwoScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "The Story Continues";

        controller = new StoryTwoController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StoryTwoView.fxml"));
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

    public StoryTwoController getController() {
        return controller;
    }
}