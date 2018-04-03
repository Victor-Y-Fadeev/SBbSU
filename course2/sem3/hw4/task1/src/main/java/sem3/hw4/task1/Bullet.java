package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** Abstract Bullet class. */
public abstract class Bullet implements Coordinate {
    protected static final int MAX_WIDTH = 1360;
    protected static final int MAX_HEIGHT = 765;

    protected static int bulletSize;
    protected static int explodeRadius;
    protected GraphicsContext gc;
    protected Image bullet;

    protected boolean exploded = false;
    protected double a;
    protected double b;
    protected double c;

    protected int x;
    protected int y;
    protected int dx;

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
        return dx > 0 ? (int) (Math.atan(b + 2 * a * x) * 180 / Math.PI) : (int) (- 135 - Math.atan(b + 2 * a * x) * 180 / Math.PI);
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setFi(int fi) {
        b = Math.tan(Math.PI * fi / 180) - 2 * a * x;
        c = y - a * x * x - b * x;

        if (fi > -90) {
            dx = 1;
        } else if (fi < -90) {
            dx = -1;
        } else {
            exploded = true;
        }
    }

    /** Get splash radius. */
    public int getRadius() {
        return explodeRadius;
    }

    /** Get bullet's type. */
    public abstract int getType();

    /** Draw Bullet. */
    public void draw() {
        gc.drawImage(bullet, x - bulletSize / 2, y - bulletSize / 2);

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
