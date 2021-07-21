package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoseScreen {

    private static Stage stage;
    private static String title;
    private LoseController controller;
    private static Scene scene;

    public LoseScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "Lose Screen";

        controller = new LoseController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoseView.fxml"));
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

    public LoseController getController() {
        return controller;
    }
}