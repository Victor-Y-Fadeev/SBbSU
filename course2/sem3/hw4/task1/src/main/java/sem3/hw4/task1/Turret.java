package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.swing.*;

/** Turret class. */
public class Turret implements Coordinate {
    private static final int MAX_WIDTH = 1360;
    private static final int MAX_HEIGHT = 765;
    private static final int TURRET_SIZE = 40;
    private static final int GUN_SIZE = 40;
    private final GraphicsContext gc;
    private final Image turret;

    private BulletFactory factory;
    private int x;
    private int y;
    private int fi;

    /** Create Turret. */
    public Turret(GraphicsContext gc, int x, int y, BulletFactory factory, String path) {
        this.factory = factory;
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.fi = -90;

        turret = new Image(path);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getFi() {
        return fi;
    }

    @Override
    public void setX(int x) {
        if ((x < 0) || (x > MAX_WIDTH)) {
            return;
        }

        this.x = x;
    }

    @Override
    public void setY(int y) {
        if ((y < 0) || (y > MAX_HEIGHT)) {
            return;
        }

        this.y = y;
    }

    @Override
    public void setFi(int fi) {
        if ((fi < -225) || (fi > 45)) {
            return;
        }

        this.fi = fi;
    }

    /** Change turret's factory. */
    public void changeFactory(BulletFactory factory) {
        this.factory = factory;
    }

    /** Up the turret's gun. */
    public void gunUp() {
        if (fi < -225) {
            return;
        }

        fi--;
    }

    /** Down the turret's gun. */
    public void gunDown() {
        if (fi > 45) {
            return;
        }

        fi++;
    }

    /** Draw Turret. */
    public void draw() {
        gc.setLineWidth(5);
        gc.setStroke(Color.rgb(195, 195, 195));
        gc.strokeLine(x, y, x + Math.cos(Math.PI * fi / 180) * GUN_SIZE, y + Math.sin(Math.PI * fi / 180) * GUN_SIZE);

        gc.drawImage(turret, x - TURRET_SIZE / 2, y - TURRET_SIZE / 2);
    }

    /** Gun fire. */
    public Bullet fire() {
        return factory.createBullet(gc, (int) (x + Math.cos(Math.PI * fi / 180) * GUN_SIZE), (int) (y + Math.sin(Math.PI * fi / 180) * GUN_SIZE), fi);
    }
}
