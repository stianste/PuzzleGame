package puzzleGame;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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
    squareArchWidth = 20,
    squareArchHeight = 20,

    //Cursor
    minCursorWidth = fieldPadding,
    maxCursorWidth = fieldPadding + fieldWidth - 2*squareWidth,
    minCursorHeight = playerField_y - squareHeight,
    maxCursorHeight = playerField_y + fieldHeight - squareHeight,
    playerCursorDefault_x = fieldPadding + 2*squareWidth,
    playerCursorDefault_y = playerField_y + (fieldHeight/2),
    cursorStroke = 2,

    //Hiders
    playerHiderY = playerField_y + fieldHeight,
    opponentHiderY = opponentField_y + fieldHeight;

    public final static int
    outOfPlaceSquares = 4,
    numberOfStartRows = 12;

    public final static Color[] squareTypes = new Color[]{Color.SALMON, Color.DARKTURQUOISE, Color.ORCHID, Color.LAWNGREEN, Color.GOLD};
    public final static Color cursorColor = Color.WHITE;
}
