package puzzleGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Puzzle Game");
        primaryStage.setScene(new Scene(root, Constants.gameWidth, Constants.gameHeight));
        primaryStage.getScene().setOnKeyPressed(keyEvent -> Cursor.moveCursor(keyEvent));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
