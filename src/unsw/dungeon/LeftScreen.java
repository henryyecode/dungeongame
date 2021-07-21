package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LeftScreen {

    private static Stage stage;
    private static String title;
    private LeftController controller;
    private static Scene scene;

    public LeftScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "yikes";

        controller = new LeftController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LeftView.fxml"));
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

    public LeftController getController() {
        return controller;
    }
}