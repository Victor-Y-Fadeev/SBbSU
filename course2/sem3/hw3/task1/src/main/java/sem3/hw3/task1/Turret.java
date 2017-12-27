package sem3.hw3.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Turret implements Coordinate {
    private static final int MAX_WIDTH = 1360;
    private static final int MAX_HEIGHT = 765;
    private static final int TURRET_SIZE = 40;
    private static final int GUN_SIZE = 40;
    private final GraphicsContext gc;
    private final Image turret;

    private int x;
    private int y;
    private int fi;

    public Turret(GraphicsContext gc, int x, int y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.fi = -90;

        turret = new Image("turret.png");
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

    public void gunUp() {
        if (fi < -225) {
            return;
        }

        fi--;
    }

    public void gunDown() {
        if (fi > 45) {
            return;
        }

        fi++;
    }

    public void draw() {
        gc.setLineWidth(5);
        gc.setStroke(Color.rgb(195, 195, 195));
        gc.strokeLine(x, y, x + Math.cos(Math.PI * fi / 180) * GUN_SIZE, y + Math.sin(Math.PI * fi / 180) * GUN_SIZE);

        gc.drawImage(turret, x - TURRET_SIZE / 2, y - TURRET_SIZE / 2);
    }
}
