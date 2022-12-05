package Model;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fruit.java
 * 
 * Object for the fruit, will have a random spawn point (for now)
 * 
 */

public class Fruit {
    private Node fruit;
    public Fruit(){
        fruit = new Node("FF4500");
    }
    public Fruit(String info){
        fruit = new Node(info);
    }
    public Fruit(int x, int y){
        fruit = new Node("FF4500");
        fruit.setX(x);
        fruit.setY(y);
    }
    // setter & getter
    public void setFruit(Node fruit) {
        this.fruit = fruit;
    } 
    public Node getFruit() {
        return fruit;
    }
    // fungsionalitas
    public void spawn(Snake player, int rows, int column){
        int x, y;
        do {
            x = (int) (Math.random() * rows);
            y = (int) (Math.random()* column);
        } while (!isSpawnable(player, x, y));
        this.fruit.setX(x);
        this.fruit.setY(y);
    }

    /**
     * spawn for two players
     * @param player1
     * @param player2
     * @param rows
     * @param column
     */
    public void spawn(Snake player1, Snake player2, int rows, int column){
        int x, y;
        do {
            x = (int)(Math.random() * rows);
            y = (int)(Math.random() * column);
        } while (!isSpawnable(player1, x, y) && !isSpawnable(player2, x, y));
        fruit.setX(x);
        fruit.setY(y);
    }

    /**
     * isSpawnable
     * to check if the coordinates from spawn is already occupied by a snake head or body or not
     * @param player --> the player snake
     * @param x x axis
     * @param y y axis
     * @return true if the coordinates is empty, false if the snake is there
     */
    public boolean isSpawnable(Snake player, int x, int y){
        if((player.getHead().getX() == x && player.getHead().getY() == y) || 
        player.getBody().contains(new Node(x, y, "4674E9"))){
            return false;
        }
        return true;
    }
    
    /**
     * 
     */
    public void drawFruit(GraphicsContext gc) {
        this.fruit.drawNode(gc);
    }
}
