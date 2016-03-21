package puzzleGame;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Cursor {

    private static double posX;
    private static double posY;
    public static Group g;

    public Cursor(Group g, double x, double y){
        posX = x;
        posY = y;
        this.g = g;
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

    public static void moveCursor(KeyEvent ke) {
        switch(ke.getCode()){
            case UP: up(); break;
            case DOWN: down(); break;
            case LEFT: left(); break;
            case RIGHT: right(); break;
            case SPACE: switchSquares(); break;
        }
        updateLocation(g);
    }

    private static void updateLocation(Group g) {
        g.relocate(posX, posY);

    }

    private static void switchSquares() {
        //TODO
        return;
    }


    private static void left() {
        if(!(posX - Constants.squareWidth < Constants.minCursorWidth)){
            posX -= Constants.squareWidth;
        }
    }

    private static void right() {
        if(!(posX + Constants.squareWidth > Constants.maxCursorWidth)) {
            posX += Constants.squareWidth;
        }
    }

    private static void down() {
        if(!(posY + Constants.squareHeight > Constants.maxCursorHeight)) {
            posY += Constants.squareHeight;
        }
    }

    private static void up() {
        if(!(posY - Constants.squareHeight < Constants.minCursorHeight)){
            posY -= Constants.squareHeight;
        }
    }
}
