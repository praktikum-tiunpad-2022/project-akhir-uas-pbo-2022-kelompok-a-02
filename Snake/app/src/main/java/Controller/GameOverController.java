package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;


public class GameOverController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private GameController g; 

    @FXML
    private Label endScore;

    public GameOverController(){
        endScore = new Label();
        
        
    }

    public void setInitialScore(String endScore){
        this.endScore.setText(endScore);

    }
  
    
    public void switchToMain(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPlay(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GameScreen.fxml"));
        root = loader.load();
        this.g = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        g.startGame(scene);
        
    }
}
