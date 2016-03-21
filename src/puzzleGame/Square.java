package puzzleGame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {
    private Color color;
    private int posx;
    private int posy;

    public Square(Color c, int x, int y){
        color = c;
        posx = x;
        posy = y;
    }

    public Color getColor() {
        return color;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getPosy() {
        return posy;
    }

    public void addTo(Pane pane) {
        Rectangle rekt = new Rectangle(posx, posy, color);
        rekt.setArcHeight(Constants.squareArchHeight);
        rekt.setArcWidth(Constants.squareArchWidth);
        pane.getChildren().add(rekt);
    }
}
