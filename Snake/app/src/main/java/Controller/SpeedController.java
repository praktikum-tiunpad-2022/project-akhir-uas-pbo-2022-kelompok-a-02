package Controller;

import java.io.IOException;

import Model.Speed;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SpeedController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private GameController g; 

    @FXML
    private Label levelSpeed; 
    
    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setEasy(ActionEvent event) throws IOException{
        setSpeed(200);
    }
    
    public void setMedium(ActionEvent event) throws IOException{
        setSpeed(120);
    }

    public void setHard(ActionEvent event) throws IOException{
        setSpeed(80);
    }

    public void setExtreme(ActionEvent event) throws IOException{
        setSpeed(40);
    }

    public void speedToText(int speed) {
        String strSpeed = "";
        switch(speed){
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

    public void setSpeed(int speed) {
        Speed.speed = speed;
        speedToText(speed);
    }
}
