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

    public void setFruit(Node fruit) {
        this.fruit = fruit;
    }
    public Node getFruit() {
        return fruit;
    }
}
