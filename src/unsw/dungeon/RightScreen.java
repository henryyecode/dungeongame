package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RightScreen {

    private static Stage stage;
    private static String title;
    private RightController controller;
    private static Scene scene;

    public RightScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "Success";

        controller = new RightController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RightView.fxml"));
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

    public RightController getController() {
        return controller;
    }
}