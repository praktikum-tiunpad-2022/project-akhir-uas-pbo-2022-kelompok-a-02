package Snake.ORA;
import Model.Snake;

import java.util.ArrayList;

import Model.Fruit;
import Model.Node;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class App extends Application{
    Fruit coba = new Fruit("FF4500");
    Snake test = new Snake(49, 49);
    ArrayList<Node> wall = new ArrayList<Node>();
    
    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}