package puzzleGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML private Rectangle playerArea, opponentArea;
    @FXML private Group playerCursor;
    @FXML private Pane mainPane;

    public Controller(){

    }
    private void start(){
        setPlayerArea();
        setOpponentArea();
        createPlayerCursor();
        createGrids();
    }

    private void createGrids() {
        Grid playerGrid = new Grid((int) Constants.playerField_x, (int) Constants.playerField_y, mainPane);
        Grid opponentGrid = new Grid((int) Constants.opponentField_x, (int) Constants.opponentField_y, mainPane);

    }

    private void createPlayerCursor() {
        Cursor cursor = new Cursor(playerCursor, Constants.playerCursorDefault_x, Constants.playerCursorDefault_y);
        cursor.generateCursor(playerCursor);
    }

    private void setPlayerArea(){
        playerArea.setWidth(Constants.fieldWidth);
        playerArea.setHeight(Constants.fieldHeight);

        playerArea.setX(Constants.playerField_x);
        playerArea.setY(Constants.playerField_y);
    }
    private void setOpponentArea(){
        opponentArea.setWidth(Constants.fieldWidth);
        opponentArea.setHeight(Constants.fieldHeight);

        opponentArea.setX(Constants.opponentField_x);
        opponentArea.setY(Constants.opponentField_y);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }
}
