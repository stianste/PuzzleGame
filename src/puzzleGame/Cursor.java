package puzzleGame;

import com.sun.jndi.cosnaming.CNCtx;
import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Cursor {

    private static double posX;
    private static double posY;
    public static Group group;
    private static Grid grid;

    public Cursor(Group g, double x, double y, Grid grid){
        posX = x;
        posY = y;
        this.group = g;
        this.grid = grid;
        grid.setX(this.getGridPosX());
        grid.setY(this.getGridPosY());

    }

    public void generateCursor(Group g){
        Line top = new Line(posX, posY, posX + 2*Constants.squareWidth, posY);
        Line left = new Line(posX, posY, posX, posY + Constants.squareHeight);
        Line bottom = new Line(posX , posY + Constants.squareHeight, posX + 2*Constants.squareWidth, posY + Constants.squareHeight);
        Line right = new Line(posX + 2*Constants.squareWidth, posY, posX + 2*Constants.squareWidth, posY + Constants.squareHeight);
        Line middle = new Line(posX + Constants.squareWidth, posY, posX + Constants.squareWidth, posY + Constants.squareHeight);

        List<Line> l = asList(top, left, bottom, right, middle);

        l.stream().forEach(line -> {
            line.setStrokeWidth(Constants.cursorStroke);
            line.setStroke(Constants.cursorColor);
        });
            g.getChildren().addAll(l);
        }

    public static void moveCursor(KeyEvent ke) {
        switch(ke.getCode()){
            case UP: up(); break;
            case DOWN: down(); break;
            case LEFT: left(); break;
            case RIGHT: right(); break;
            case SPACE: switchSquares(); break;
        }
        updateLocation(group);
    }

    private static void updateLocation(Group g) {
        group.relocate(posX, posY);
        grid.setX(getGridPosX());
        grid.setY(getGridPosY());

    }

    private static void switchSquares() {
        //-1 at the y position to account for the extra row.
        Square left = grid.findMatchingSquare(getGridPosX(), getGridPosY()-1);
        Square right = grid.findMatchingSquare(getGridPosX()+1, getGridPosY()-1);
        grid.switchSquares(getGridPosY(), getGridPosX());
        left.moveRight();
        right.moveLeft();
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
    public static int getGridPosX(){
        System.out.println(posX);
        return (int) Math.floor((posX - Constants.playerField_x)/(Constants.squareWidth));
    }

    public static int getGridPosY(){
        return (int) Math.floor((posY - Constants.playerField_y)/(Constants.squareHeight) + 1);
    }
}
