package Model;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Node> body;
    private Node head;
    public Snake(){
        body = new LinkedList<Node>();
        head = new Node();
    }
}
