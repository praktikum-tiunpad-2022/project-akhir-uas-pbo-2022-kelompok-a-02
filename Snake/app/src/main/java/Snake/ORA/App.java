package Snake.ORA;
import Model.Snake;

import java.util.ArrayList;

import Model.DIRECTION;
import Model.Fruit;
// import Model.Node;
import Model.Node;

// import java.util.concurrent.TimeUnit;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
// import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application{
    private GraphicsContext gc;
    // Node coba = new Node(10, 10, "4674E9");
    Fruit coba = new Fruit("FF4500");
    Snake test = new Snake(49, 49);
    ArrayList<Node> wall = new ArrayList<Node>();
    
    @Override
    public void start(Stage stage){
        // try{
        //     Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        //     Scene scene = new Scene(root);
        //     stage.setScene(scene);
        //     stage.show();
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        // buat ngikut tutorial aja, nanti apus or masukin ke Game.java
        stage.setTitle("Snake");
        Group root = new Group();
        Canvas canvas = new Canvas(800, 800);
        root.getChildren().add(canvas);
        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.show();
        gc = canvas.getGraphicsContext2D();

        coba.spawn(test, 20, 20);

        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event){
                KeyCode code = event.getCode();
                if(code == KeyCode.A){
                    test.setDir(DIRECTION.LEFT);
                } else if(code == KeyCode.S){
                    test.setDir(DIRECTION.DOWN);
                } else if(code == KeyCode.D){
                    test.setDir(DIRECTION.RIGHT);
                } else if(code == KeyCode.W){
                    test.setDir(DIRECTION.UP);
                }
                
            }
        });{
            
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        run(gc);

    }

    private void run(GraphicsContext gc) {
        drawBackground(gc);
        coba.getFruit().drawNode(gc);  
        test.drawSnake(gc);
        if(isHitting(test)) return;
        test.moveSnake(coba);
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

    private boolean isHitting(Snake player){
        return(hitBody(player) || hitWall(player));
    }
    
    private boolean hitBody(Snake player){
        for (int i = 0; i < player.getBody().size(); i++) {
            if(player.getHead().sameCoor(player.getBody().get(i))) return true;
        }
        return false;
    }

    private boolean hitWall(Snake player){
        return (player.getHead().getX() == 100 || player.getHead().getY() == 100 
        || player.getHead().getX() == -1 || player.getHead().getY() == -1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}