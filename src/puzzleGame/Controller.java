package puzzleGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

//TODO: Figure out how to refer to constant variables in the fxml

public class Controller implements Initializable{
    @FXML private Rectangle playerArea, opponentArea, playerBottomRowHider, opponentBottomRowHider;
    @FXML private Group playerCursor;
    @FXML private Pane mainPane;

    public Controller(){

    }
    private void start(){
        setPlayerArea();
        setOpponentArea();
        createPlayerCursor();
        createGrids();
        addHiders();
    }
    private void addHiders(){
        playerBottomRowHider.toFront();
        opponentBottomRowHider.toFront();

        playerBottomRowHider.setWidth(Constants.fieldWidth);
        playerBottomRowHider.setHeight(Constants.squareHeight);
        playerBottomRowHider.relocate(Constants.playerField_x,
                Constants.playerField_y + Constants.fieldHeight);

        opponentBottomRowHider.setWidth(Constants.fieldWidth);
        opponentBottomRowHider.setHeight(Constants.squareHeight);
        opponentBottomRowHider.relocate(Constants.opponentField_x,
                Constants.opponentField_y + Constants.fieldHeight);
    }

    private void createGrids() {
        Grid playerGrid = new Grid(Constants.playerField_x, Constants.playerField_y, mainPane);
        Grid opponentGrid = new Grid(Constants.opponentField_x, Constants.opponentField_y, mainPane);

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
