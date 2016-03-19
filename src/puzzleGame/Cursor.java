package puzzleGame;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Cursor {

    private Color color;
    private double posX;
    private double posY;

    public Cursor(Color color, double x, double y){
        this.color = color;
        posX = x;
        posY = y;
    }

    public void generateCursor(Group g){
        Line top = new Line(posX, posY, posX + 2*Constants.squareWidth, posY);
        Line left = new Line(posX, posY, posX, posY + Constants.squareHeight);
        Line bottom = new Line(posX , posY + Constants.squareHeight, posX + 2*Constants.squareWidth, posY + Constants.squareHeight);
        Line right = new Line(posX + 2*Constants.squareWidth, posY, posX + 2*Constants.squareWidth, posY + Constants.squareHeight);
        Line middle = new Line(posX + Constants.squareWidth, posY, posX + Constants.squareWidth, posY + Constants.squareHeight);

        g.getChildren().addAll(top, left, bottom, right, middle);
        //Make the cursor lines white using HSL
        g.getChildren().stream().forEach(child -> child.setEffect(new ColorAdjust(360, 1.0, 1.0, 1)));

    }
}
