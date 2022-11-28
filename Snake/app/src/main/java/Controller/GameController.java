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
    private Fruit makan = new Fruit("FF4500");
    private Snake uler = new Snake(49, 49);
    private GraphicsContext gc;
    private Scene s;

    @FXML
    private Canvas canvasGame;

    public GameController(){
              
    }

    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private void drawBackground() {
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
        this.drawBackground();
        makan.getFruit().drawNode(gc);  
        uler.drawSnake(gc);
        if(isHitting()) return;
        uler.moveSnake(makan);
        
    }

    public void startGame(Scene gameScene){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        makan.spawn(uler, 100, 100);

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

  
    
}
