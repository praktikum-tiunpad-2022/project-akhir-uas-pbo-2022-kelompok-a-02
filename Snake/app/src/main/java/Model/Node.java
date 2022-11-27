// package Model;
package Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/** 
 * Node.java
 * Foundation for all the blocks that are in the game.
 * x and y is used for coordinates.
 * info is used to link the block with a picture or color to draw the object
 */
public class Node {
    private int x, y;
    private String info;
    // info buat apa yang mau ditampilin
    
    // gambar, pembantu buat ngegambar pada guinya
    public Node(){
        x = 0;
        y = 0;
        info = "";
    }
    public Node(int x, int y, String info){
        this.x = x;
        this.y = y;
        this.info = info;
    }
    public Node (String info){
        this.info = info;
    }
    // Setter
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    // Getter 
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getInfo() {
        return info;
    }

    // fungsi 
    /**
     * drawNode
     * used for drawing the node in the coordinates
     */
    public void drawNode(GraphicsContext gambar){
        gambar.setFill(Color.web(info));
        gambar.fillRoundRect(x*8, y*8, 8, 8, 35, 35);
    }

    public boolean sameCoor(Node dua){
        return (this.x == dua.getX() && this.y == dua.getY());
    }
}
