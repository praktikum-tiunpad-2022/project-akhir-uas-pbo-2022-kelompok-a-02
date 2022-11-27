package Model;
/**
 * Fruit.java
 * 
 * Object for the fruit, will have a random spawn point (for now)
 * 
 */

public class Fruit {
    private Node fruit;
    public Fruit(){
        fruit = new Node();
    }
    public Fruit(String info){
        fruit = new Node(info);
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
    
}
