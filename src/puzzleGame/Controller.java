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

    private void start(){
        createPlayerCursor();
        createGrids();
        addHiders();
    }
    private void addHiders(){
        playerBottomRowHider.toFront();
        opponentBottomRowHider.toFront();
    }

    private void createGrids() {
        Grid playerGrid = new Grid(Constants.playerField_x, Constants.playerField_y, mainPane);
        Grid opponentGrid = new Grid(Constants.opponentField_x, Constants.opponentField_y, mainPane);

    }

    private void createPlayerCursor() {
        Cursor cursor = new Cursor(playerCursor, Constants.playerCursorDefault_x, Constants.playerCursorDefault_y);
        cursor.generateCursor(playerCursor);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }
}
