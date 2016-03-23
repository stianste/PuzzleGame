package puzzleGame;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {
    private Color color;
    private double posx;
    private double posy;
    private int x;
    private int y;
    private Rectangle rekt;

    public Square(Color c, double posx, double posy, int x, int y){
        color = c;
        this.posx = posx;
        this.posy = posy;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public double getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public double getPosy() {
        return posy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft(){
        this.x -= 1;
        this.posx -= Constants.squareWidth;
        this.rekt.relocate(posx, posy);
    }

    public void moveRight(){
        this.x += 1;
        this.posx += Constants.squareWidth;
        this.rekt.relocate(posx, posy);
    }
    public void addTo(Pane pane) {
        this.rekt = new Rectangle(posx, posy, Constants.squareWidth, Constants.squareHeight);
        rekt.setFill(color);
        rekt.setArcHeight(Constants.squareArchHeight);
        rekt.setArcWidth(Constants.squareArchWidth);
        pane.getChildren().add(rekt);
    }
    public void setColor(Color c){
        //Used for testing, should be removed eventually
        this.color = c;
        this.rekt.setFill(c);
    }

    public void remove(Pane p) {
        p.getChildren().remove(this.rekt);
        this.rekt = null;
    }
}
