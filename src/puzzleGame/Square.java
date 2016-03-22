package puzzleGame;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {
    private Color color;
    private double posx;
    private double posy;

    public Square(Color c, double x, double y){
        color = c;
        posx = x;
        posy = y;
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

    public void addTo(Pane pane) {
        Rectangle rekt = new Rectangle(posx, posy, Constants.squareWidth, Constants.squareHeight);
        rekt.setFill(color);
        rekt.setArcHeight(Constants.squareArchHeight);
        rekt.setArcWidth(Constants.squareArchWidth);
        pane.getChildren().add(rekt);
    }
}
