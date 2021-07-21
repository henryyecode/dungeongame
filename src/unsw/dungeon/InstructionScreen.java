package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InstructionScreen {

    private static Stage stage;
    private static String title;
    private InstructionController controller;
    private static Scene scene;

    public InstructionScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "instructions";

        controller = new InstructionController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InstructionView.fxml"));
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

    public InstructionController getController() {
        return controller;
    }
}