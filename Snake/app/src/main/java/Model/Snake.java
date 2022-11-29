package Model;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

/**
 * Snake.java
 * The snake object, the thing the player will control when playing
 * 
 * list body is used to store all the coordinates of the snake body
 * head is the head of the snake.
 * 
 */ 

public class Snake {
    private ArrayList<Node> body;
    private Node head;
    
    DIRECTION dir = DIRECTION.RIGHT;
    public Snake(){
        body = new ArrayList<Node>();
        head = new Node();
    }
    public Snake(int x, int y){
        head = new Node(x, y, "E92f88");
        body = new ArrayList<Node>();
        for (int i = 1; i <= 5; i++) {
            body.add(new Node(x-i, y, "4674E9"));
        }
    }
    // setter
    public void setBody(ArrayList<Node> body) {
        this.body = body;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    /**
     * to change the DIRECTION attribute.
     * if the initial direction is left and the input is right, 
     * the input is ignored and vice versa. 
     * same situation with up and down
     * 
     * @param dir
     *      the direction input
     */
    public void setDir(DIRECTION dir) {
        // disabling the snake going backwards
        if((this.dir == DIRECTION.UP && dir == DIRECTION.DOWN) ||
        (this.dir == DIRECTION.DOWN && dir == DIRECTION.UP) ||
        (this.dir == DIRECTION.RIGHT && dir == DIRECTION.LEFT) ||
        (this.dir == DIRECTION.LEFT && dir == DIRECTION.RIGHT))
            return;
        this.dir = dir;
    }

    // getter
    public ArrayList<Node> getBody() {
        return body;
    }
    public Node getHead() {
        return head;
    }
    public DIRECTION getDir() {
        return dir;
    }

    // fungsi
    /**
     * dipakai saat snake makan. 
     * event -> nambah satu node ke body
     * untuk sementara, insertLast dulu
     */
    public void addNode(){

    }

    public void drawSnake(GraphicsContext gambar){
        for (int i = 0; i < body.size(); i++) {
            body.get(i).drawNode(gambar);
        }
        head.drawNode(gambar);
    }

    // public boolean isEating(Fruit food){
    //     if(this.head.getX() == food.getFruit().getX() && 
    //     this.head.getY() == food.getFruit().getY()){
    //         return true;
    //     }
    //     return false;
    // }

    /**
     * move the rest of the body forward
     * WARNING : Might be source of bug 
     *      -> gajadi, karena diubah dikit algonya
     */
    public void moveSnake(Point point, Fruit food){
        int x = head.getX();
        int y = head.getY();
        dir.moveHead(head);

        if(head.sameCoor(food.getFruit())){
            body.add(0, new Node(x, y, "4674E9"));
            food.spawn(this, 20, 20);
            point.addPoint();
        } else {
            moveBody(x, y);
        }
    }

    /**
     * 
     * @param x --> head x
     * @param y --> head y
     */
    public void moveBody(int x, int y){
        for (int i = body.size()-1; i > 0; i--) {
            body.get(i).setX(body.get(i-1).getX());
            body.get(i).setY(body.get(i-1).getY());
        }
        body.get(0).setX(x);
        body.get(0).setY(y);
    }

    public void deleteAllBody(){
        this.body.clear();
        
    }


}
