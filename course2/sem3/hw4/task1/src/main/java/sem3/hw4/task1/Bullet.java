package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** Bullet class. */
public class Bullet implements Coordinate {
    private static final int MAX_WIDTH = 1360;
    private static final int MAX_HEIGHT = 765;
    private static final int BULLET_SIZE = 20;
    private final GraphicsContext gc;
    private final Image bullet;

    private boolean exploded = false;
    private double a = 0.005;
    private double b;
    private double c;

    private int x;
    private int y;
    private int dx;

    /** Create Bullet. */
    public Bullet(GraphicsContext gc, int x, int y, int fi) {
        this.gc = gc;
        this.x = x;
        this.y = y;

        b = Math.tan(Math.PI * fi / 180) - 2 * a * x;
        c = y - a * x * x - b * x;

        if (fi > -90) {
            dx = 1;
        } else if (fi < -90) {
            dx = -1;
        } else {
            explode();
        }

        bullet = new Image("bullet.png");
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
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    /** Draw Bullet. */
    public void draw() {
        gc.drawImage(bullet, x - BULLET_SIZE / 2, y - BULLET_SIZE / 2);

        x += dx;
        y = (int) (a * x * x + b * x + c);

        if ((x < 0) || (x > MAX_WIDTH) || (y < 0) || (y > MAX_HEIGHT)) {
            explode();
        }
    }

    /** Explode Bullet. */
    public void explode() {
        exploded = true;
    }

    /** Check bullet's destruction. */
    public boolean isExploded() {
        return exploded;
    }
}
