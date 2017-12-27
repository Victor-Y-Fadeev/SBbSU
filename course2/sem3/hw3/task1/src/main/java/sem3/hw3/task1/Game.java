package sem3.hw3.task1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.scene.canvas.Canvas;

import java.util.LinkedList;

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

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.scale((double) screenWidth / basicWidth, (double) screenHeight / basicHeight);

        Map map = new Map(gc);
        Turret turret = new Turret(gc, 680, 0);
        map.putOnTheGround(turret);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                map.draw();

                if (input.contains("LEFT")) {
                    turret.setX(turret.getX() - 1);
                    map.putOnTheGround(turret);
                }

                if (input.contains("RIGHT")) {
                    turret.setX(turret.getX() + 1);
                    map.putOnTheGround(turret);
                }

                if (input.contains("UP")) {
                    turret.gunUp();
                }

                if (input.contains("DOWN")) {
                    turret.gunDown();
                }

                turret.draw();
            }
        }.start();

        primaryStage.show();
    }

    /** Main function. */
    public static void main(String[] args) {
        launch(args);
    }
}