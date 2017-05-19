package spbu.test2.task1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/** The Main class. */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Scene.fxml"));
        primaryStage.setTitle("Pair");
        primaryStage.setScene(new Scene(root, 240, 240));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    /** The Main method. */
    public static void main(String[] args) {
        launch(args);
    }
}