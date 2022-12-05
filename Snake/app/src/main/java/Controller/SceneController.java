package Controller;

import java.beans.EventHandler;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import Model.*;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private GameController g; 
    @FXML
    private Label levelSpeed = new Label(); 

    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToScore(ActionEvent event) throws IOException{
        root = FXMLLoader.load(
        getClass().getResource("/View/ScoreBoard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param event
     * @throws IOException
     */
    public void switchToPlay(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DoublePlayerScreen.fxml"));
        root = loader.load();
        this.g = loader.getController();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        g.startGame(scene);
        
    }

    public void switchToMainAfterPlay(ActionEvent event) throws IOException{
        g.clearGame();
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param event
     * @throws IOException
     */
    public void switchToSetting(ActionEvent event) throws IOException{
        root = FXMLLoader.load(
        getClass().getResource("/View/Setting.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        speedToText();
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent event) throws IOException{
        System.exit(0);
    }

    public void speedToText() {
        String strSpeed = "";
        switch(Speed.speed){
            case 200: 
                strSpeed = "Easy";break;
            case 120: 
                strSpeed = "Medium";break;
            case 80: 
                strSpeed = "Hard";break;
            case 40: 
                strSpeed = "Extreme";break;
        }
        levelSpeed.setText(strSpeed);
    }
}



