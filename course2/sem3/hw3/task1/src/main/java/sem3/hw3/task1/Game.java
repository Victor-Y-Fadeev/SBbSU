package sem3.hw3.task1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.scene.canvas.Canvas;

/** The Game class. */
public class Game extends Application {
    /** Start The Game. */
    @Override
    public void start(Stage primaryStage) throws Exception {
        final int basicWidth = 1360;
        final int basicHeight = 765;
        final int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
        final int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();

        primaryStage.setTitle("Tanks");
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(screenWidth, screenHeight);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.scale((double) screenWidth / basicWidth, (double) screenHeight / basicHeight);

        Map background = new Map(gc);

        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                background.draw();
                // background image clears canvas
                //gc.drawImage( space, 0, 0 );
                //gc.drawImage( earth, 0, 0);//, 1920, 1080);
                //gc.drawImage( sun, 196, 196 );
            }
        }.start();

        primaryStage.show();
    }

    /** Main function. */
    public static void main(String[] args) {
        launch(args);
    }
}