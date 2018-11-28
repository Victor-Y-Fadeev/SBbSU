package sem3.hw4.task1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import java.util.LinkedList;

/** The Main class. */
public class Main extends Application {
    private static final int BASIC_WIDTH = 1360;
    private static final int BASIC_HEIGHT = 765;

    private static Network network;

    /** Start The Main. */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tanks");
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        LinkedList<String> keys = keyboardSettings(scene);

        int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight() + 40;
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.scale((double) screenWidth / BASIC_WIDTH, (double) screenHeight / BASIC_HEIGHT);

        Game game = new Game(primaryStage, gc, keys, network);
        game.play();

        primaryStage.show();
    }

    /** Main function. */
    public static void main(String[] args) {
        network = new Network();
        launch(args);
    }

    private LinkedList<String> keyboardSettings(Scene scene) {
        LinkedList<String> input = new LinkedList<>();

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();

                        if (!input.contains(code)) {
                            input.add(code);
                        }
                    }
                });

        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });

        return input;
    }
}
