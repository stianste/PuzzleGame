package puzzleGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private Rectangle playerArea, opponentArea;
    @FXML
    private Group playerCursor;


    public Controller(){

    }
    private void start(){
        setPlayerArea();
        setOpponentArea();
        createPlayerCursor();
    }

    private void createPlayerCursor() {
        Cursor c = new Cursor(Constants.cursorColor, Constants.playerCursorDefault_x, Constants.playerCursorDefault_y);
        c.generateCursor(playerCursor);
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
