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
    squareWidth = fieldWidth/6,
    squareHeight = fieldHeight/12,

    //Cursor
    playerCursorDefault_x = fieldPadding + 2*squareWidth,
    playerCursorDefault_y = playerField_y + (fieldHeight/2);

    public final static Color cursorColor = Color.WHITE;

}
