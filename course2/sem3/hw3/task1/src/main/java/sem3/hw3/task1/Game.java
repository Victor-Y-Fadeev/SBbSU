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
    private static final int BASIC_WIDTH = 1360;
    private static final int BASIC_HEIGHT = 765;

    /** Start The Game. */
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

        gameMechanics(primaryStage, gc, keys);
        primaryStage.show();
    }

    /** Main function. */
    public static void main(String[] args) {
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

    private void gameMechanics(Stage primaryStage, GraphicsContext gc, LinkedList<String> keys) {
        Map map = new Map(gc);
        Turret turret = new Turret(gc, 680, 0);
        map.putOnTheGround(turret);
        LinkedList<Bullet> bullets = new LinkedList<>();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                map.draw();

                if (keys.contains("LEFT")) {
                    turret.setX(turret.getX() - 1);
                    map.putOnTheGround(turret);
                }

                if (keys.contains("RIGHT")) {
                    turret.setX(turret.getX() + 1);
                    map.putOnTheGround(turret);
                }

                if (keys.contains("UP")) {
                    turret.gunUp();
                }

                if (keys.contains("DOWN")) {
                    turret.gunDown();
                }

                turret.draw();

                if (keys.contains("ENTER")) {
                    bullets.add(turret.fire());
                    keys.remove("ENTER");
                }

                cleanBullets(map, bullets);
                bullets.forEach(bullet -> bullet.draw());

                if (keys.contains("ESCAPE")) {
                    primaryStage.close();
                }
            }
        }.start();
    }

    private void cleanBullets(Map map, LinkedList<Bullet> bullets) {
        LinkedList<Bullet> toRemove = new LinkedList<>();

        for (Bullet bullet : bullets) {
            if (map.isOnTheGround(bullet)) {
                bullet.explode();
            }

            if (bullet.isExploded()) {
                toRemove.add(bullet);
            }
        }

        for (Bullet bullet : toRemove) {
            bullets.remove(bullet);
        }
    }
}