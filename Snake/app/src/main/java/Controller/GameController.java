package Controller;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;


import Model.*;

public class GameController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Fruit buah;
    private Snake uler;
    private GraphicsContext gc;
    private Point point;
    private Timeline timeline;

    @FXML
    private Canvas canvasGame;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button tButton;

   

    public GameController(){
        buah = new Fruit("FF4500");
        uler = new Snake(49, 49);
        point = new Point();
        scoreLabel = new Label("0");
       
    }

    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMainAfterPlay(ActionEvent event) throws IOException{
        this.clearGame();
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        
    }

    
    
    private void drawBackground(GraphicsContext gc) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if ((i + j) % 2 == 0){
                    gc.setFill(Color.web("AAD751"));
                } else{
                    gc.setFill(Color.web("A2D149"));
                }
                gc.fillRect(i*8, j*8, 8, 8);
            }
        }
    }

 

    public void run(){
        this.gc = this.canvasGame.getGraphicsContext2D();
        // buah.drawFruit(gc);  
        uler.drawSnake(gc);
        if(isHitting()){
            try {
                GameOverController gcc = new GameOverController();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GameOver.fxml"));
                root = loader.load();
                gcc = loader.getController();
                
                stage = (Stage) tButton.getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                gcc.setInitialScore(this.scoreLabel.getText());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        uler.moveSnake(isEating());
        scoreLabel.setText(String.valueOf(point.getPoint()));
        
    }
    
    public void startGame(Scene gameScene){
        this.gc = this.canvasGame.getGraphicsContext2D();
        this.drawBackground(this.gc);
        buah.spawn(uler, 100, 100);
        buah.drawFruit(gc);  
        this.timeline = new Timeline(new KeyFrame(Duration.millis(Speed.speed), e -> run()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

          gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event){
                KeyCode code = event.getCode();
                if(code == KeyCode.A){
                    uler.setDir(DIRECTION.LEFT);
                } else if(code == KeyCode.S){
                    uler.setDir(DIRECTION.DOWN);
                } else if(code == KeyCode.D){
                    uler.setDir(DIRECTION.RIGHT);
                } else if(code == KeyCode.W){
                    uler.setDir(DIRECTION.UP);
                }
                
            }
        
        });{
           
        }
    }

   

    public void clearGame(){
        this.uler.deleteAllBody();
        this.timeline.stop();
        this.timeline.getKeyFrames().clear();
        this.timeline = null;
    }

     private boolean isHitting(){
        return(hitBody() || hitWall());
    }

     private boolean hitBody(){
        for (int i = 0; i < this.uler.getBody().size(); i++) {
            if(this.uler.getHead().sameCoor(this.uler.getBody().get(i))) return true;
        }
        return false;
    }

    private boolean hitWall(){
        return (this.uler.getHead().getX() == 100 || this.uler.getHead().getY() == 100 
        || this.uler.getHead().getX() == -1 || this.uler.getHead().getY() == -1);
    }

    public boolean isEating() {
        boolean isEat = uler.getHead().sameCoor(buah.getFruit());
        if(isEat){
            gc = canvasGame.getGraphicsContext2D();
            buah.spawn(uler, 100, 100);
            buah.drawFruit(gc);
            this.point.addPoint();
        }
        return isEat;
    }
}