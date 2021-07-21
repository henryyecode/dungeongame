package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;

public class DungeonScreen {
	//private static final Node  = null;
	private static Stage stage;
    private static String title;
    private static DungeonController controller;
    private static Scene scene;
    public static String json = "maze";
    public static Timeline gameloop;
	public static boolean isStory = false;
	public static int story;

    public DungeonScreen(Stage stage) throws IOException {
        DungeonScreen.stage = stage;
        DungeonScreen.title = json;
        
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader(json + ".json");
        controller = dungeonLoader.loadController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);
        root.requestFocus();

        DungeonScreen.gameloop = new Timeline();
        gameloop.setCycleCount(Timeline.INDEFINITE);
        final long gameStartTime = System.currentTimeMillis();
        KeyFrame newKeyFrame = new KeyFrame(
    		Duration.seconds(0.017),
    		new EventHandler<ActionEvent>() 
    		{
    			public void handle(ActionEvent ae)
                {
                    double t = (System.currentTimeMillis() - gameStartTime) / 1000.0; 
                                
                    try {
						controller.update();
					} catch (IOException e) {
						e.printStackTrace();
					}
                    
                }
            }
    	);
	    gameloop.getKeyFrames().add(newKeyFrame);

       
    }

    public void start() throws IOException {
    	
    	DungeonScreen.title = json;
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader(json + ".json");
        controller = dungeonLoader.loadController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        BorderPane pane = new BorderPane();
        GridPane grid = new GridPane();
        ArrayList<GoalComponent> hehe = dungeonLoader.getGoalsArray();
        int i = 0;
        for (GoalComponent G : hehe) {
        	//System.out.println(G.goalName());
        	Label newlabel = new Label(G.goalName().get());
        	G.goalName().bindBidirectional(newlabel.textProperty());
        	grid.add(newlabel, 0, i);
        	i = i + 2;
        }
        pane.setRight(grid);
        
        Inventory inventory = controller.getInventory();
        GridPane inventoryGrid  = new GridPane();
        
    	inventoryGrid.add(new ImageView(new Image("/greatsword_1_new.png")), 0,0);
    	Label numSword = new Label(inventory.getNumSword().toString());
        Bindings.bindBidirectional(numSword.textProperty(), inventory.getNumSword(), new NumberStringConverter());
        inventoryGrid.add(numSword, 1, 0);
    	
    	inventoryGrid.add(new ImageView(new Image("/bomb_unlit.png")), 2,0);
    	Label numBomb = new Label(inventory.getNumBomb().toString());
        Bindings.bindBidirectional(numBomb.textProperty(), inventory.getNumBomb(), new NumberStringConverter());
        inventoryGrid.add(numBomb, 3, 0);
    	
    	inventoryGrid.add(new ImageView(new Image("/key.png")), 4,0);
    	Label numKey = new Label(inventory.getNumKey().toString());
        Bindings.bindBidirectional(numKey.textProperty(), inventory.getNumKey(), new NumberStringConverter());
        inventoryGrid.add(numKey, 5, 0);
        
    	inventoryGrid.add(new ImageView(new Image("/brilliant_blue_new.png")), 6,0);
    	Label numPotion = new Label(inventory.getNumPotion().toString());
        Bindings.bindBidirectional(numPotion.textProperty(), inventory.getNumPotion(), new NumberStringConverter());
        inventoryGrid.add(numPotion, 7, 0);
        
        
        
        pane.setBottom(inventoryGrid);
        loader.setController(controller);
        Parent root = loader.load();
        pane.setCenter(root);
        scene = new Scene(pane);
        
        root.requestFocus();
    	   
	    gameloop.play();
        
    	stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    
    public void story(int i) throws IOException {
    	story = i;
    	this.start();
    }
    
    public static void pause()  throws IOException {
    	gameloop.pause();
    }
    
    public static void resume() throws IOException {
	  
    	gameloop.play();
		stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
	}
    
    public static void setJSON(String s) {
        DungeonScreen.json = s; 
    }

	public DungeonController getController() {
		return controller;
	}


}