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
    @FXML private Rectangle playerBottomRowHider, opponentBottomRowHider;
    @FXML private Group playerCursor;
    @FXML private Pane mainPane;

    private static Grid playerGrid;
    private static Grid opponentGrid;

    private void start(){
        createGrids();
        createPlayerCursor();
        addHiders();
    }
    private void addHiders(){
        playerBottomRowHider.toFront();
        opponentBottomRowHider.toFront();
    }

    private void createGrids() {
        this.playerGrid = new Grid(Constants.playerField_x, Constants.playerField_y, mainPane);
        this.opponentGrid = new Grid(Constants.opponentField_x, Constants.opponentField_y, mainPane);

    }

    private void createPlayerCursor() {
        Cursor cursor = new Cursor(playerCursor, Constants.playerCursorDefault_x, Constants.playerCursorDefault_y, this.playerGrid);
        cursor.generateCursor(playerCursor);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }
}
