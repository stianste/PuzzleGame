package puzzleGame;

import javafx.scene.paint.Color;

public class Constants {
    public final static double
    //General
    gameWidth = 1080,
    gameHeight = 720,

    //Fields
    fieldPadding = 100,
    fieldWidth = gameWidth/3,
    fieldHeight = gameHeight - 100,
    playerField_x = fieldPadding,
    playerField_y = 50,
    opponentField_x = gameWidth - fieldPadding - fieldWidth,
    opponentField_y = playerField_y,

    //Squares
    numberOfSquaresWidth = 6,
    numberOfSquaresHeight = 12,
    squareWidth = fieldWidth/numberOfSquaresWidth,
    squareHeight = fieldHeight/numberOfSquaresHeight,
    squareArchWidth = 10,
    squareArchHeight = 10,
    //Cursor
    minCursorWidth = fieldPadding,
    maxCursorWidth = fieldPadding + fieldWidth - 2*squareWidth,
    minCursorHeight = playerField_y - squareHeight,
    maxCursorHeight = playerField_y + fieldHeight - squareHeight,
    playerCursorDefault_x = fieldPadding + 2*squareWidth,
    playerCursorDefault_y = playerField_y + (fieldHeight/2);

    public final static int outOfPlaceSquares = 4;

    //Length of squareTypes should match
    //TODO: find some nicer colors.
    public final static Color[] squareTypes = new Color[]{Color.RED, Color.BLUE, Color.PURPLE, Color.GREEN, Color.YELLOW};
    public static int numberOfStartRows = 5;
}
