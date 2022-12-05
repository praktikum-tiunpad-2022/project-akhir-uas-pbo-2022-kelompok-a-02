package Controller;

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
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

import Model.*;

public class DuoGameController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private GraphicsContext gc;
    private Timeline timeline;
    
    private Snake player1, player2;
    private boolean isDead1 = false, isDead2 = false;
    private Point point1, point2;
    private ArrayList<Fruit> foods ;

    @FXML
    private Canvas canvasGame;
    @FXML
    private Label playerOneScore;
    @FXML
    private Label playerTwoScore;

    public DuoGameController(){
        player1 = new Snake(25, 49);
        player2 = new Snake(75, 49);
        player2.setDir(DIRECTION.LEFT);
        playerOneScore = new Label("0");
        point1 = new Point();
        playerOneScore.setText(String.valueOf(point1.getPoint()));
        playerTwoScore = new Label("0");
        point2 = new Point();
        playerTwoScore.setText(String.valueOf(point2.getPoint()));
        foods = new ArrayList<Fruit>();
        for (int i = 0; i < 4; i++) {
            foods.add(new Fruit());
        }

    }

    public void startGame(Scene gameScene){
        this.gc = canvasGame.getGraphicsContext2D();
        this.drawBackground();
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).spawn(player1, player2, 100, 100);
            foods.get(i).drawFruit(gc);
        }
        this.timeline = new Timeline(new KeyFrame(Duration.millis(Speed.speed), e -> run()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                switch(event.getCode()){
                    case W:
                        player1.setDir(DIRECTION.UP);
                        break;
                    case A:
                        player1.setDir(DIRECTION.LEFT);
                        break;
                    case S:
                        player1.setDir(DIRECTION.DOWN);
                        break;
                    case D:
                        player1.setDir(DIRECTION.RIGHT);
                        break;
                    case I:
                        player2.setDir(DIRECTION.UP);
                        break;
                    case J:
                        player2.setDir(DIRECTION.LEFT);
                        break;
                    case K:
                        player2.setDir(DIRECTION.DOWN);
                        break;
                    case L:
                        player2.setDir(DIRECTION.RIGHT);
                        break;
                    default:
                        break;
                }
                
            }
        });
        
    }

    private void drawBackground() {
        this.gc = this.canvasGame.getGraphicsContext2D();

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
        player1.drawSnake(gc);
        player2.drawSnake(gc);

        if(isHitting(player1) || isHitting(player2)) return;
        player1.moveSnake(isEating(player1, point1));
        playerOneScore.setText(String.valueOf(point1.getPoint()));

        player2.moveSnake(isEating(player2, point2));
        playerTwoScore.setText(String.valueOf(point2.getPoint()));
    }

    public boolean isEating(Snake uler, Point point) {
        for (int i = 0; i < foods.size(); i++) {
            if(uler.getHead().sameCoor(foods.get(i).getFruit())){
                gc = canvasGame.getGraphicsContext2D();
                foods.get(i).spawn(player1, player2, 100, 100);
                foods.get(i).drawFruit(gc);
                point.addPoint();
                return true;
            }
        }
        return false;
    }

    private boolean isHitting(Snake uler){
        return(hitBody(uler) || hitWall(uler));
    }

     private boolean hitBody(Snake uler){
        for (int i = 0; i < uler.getBody().size(); i++) {
            if(uler.getHead().sameCoor(uler.getBody().get(i))) return true;
        }
        return false;
    }

    private boolean hitWall(Snake uler){
        return (uler.getHead().getX() == 100 || uler.getHead().getY() == 100 
        || uler.getHead().getX() == -1 || uler.getHead().getY() == -1);
    }

    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(
        getClass().getResource("/View/MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
