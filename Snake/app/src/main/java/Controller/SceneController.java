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
    private DuoGameController game;
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
    public void switchToDoublePlay(ActionEvent event) throws IOException{
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DoublePlayerScreen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DoublePlayerScreen.fxml"));
        root = loader.load();
        this.game = loader.getController();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        game.startGame(scene);
        
    }

    public void switchToSinglePlay(ActionEvent event) throws IOException{
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DoublePlayerScreen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GameScreen.fxml"));
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

    public void switchToSetting(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(
        getClass().getResource("/View/Setting.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent event) throws IOException{
        System.exit(0);
    }

    



}



