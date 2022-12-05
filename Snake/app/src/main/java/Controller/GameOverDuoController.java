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


public class GameOverDuoController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private GameController g; 
    private DuoGameController g2;

    @FXML
    private Label winnerLabel;

    @FXML
    private Label p1Score;

    @FXML
    private Label p2Score;

    public GameOverDuoController(){
        winnerLabel = new Label();
        p1Score = new Label();
        p2Score = new Label();
        
        
    }

    public void setInitialScore(String winner , String score1,String score2){
        this.winnerLabel.setText(winner);
        this.p1Score.setText(score1);
        this.p2Score.setText(score2);

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DoublePlayerScreen.fxml"));
        root = loader.load();
        this.g2 = loader.getController();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        g2.startGame(scene);
        
    }
}
