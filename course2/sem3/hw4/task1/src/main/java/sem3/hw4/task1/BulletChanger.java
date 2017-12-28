package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BulletChanger {
    private final GraphicsContext gc;
    private final Turret turret;

    private boolean isLow;

    public BulletChanger(GraphicsContext gc, Turret turret, boolean isLow) {
        this.gc = gc;
        this.turret = turret;
        this.isLow = isLow;
    }

    public void change() {
        if (isLow) {
            turret.changeFactory(new HighBulletFactory());
        } else {
            turret.changeFactory(new LowBulletFactory());
        }

        isLow = !isLow;
    }

    public void draw() {
        final int X = 1190;
        final int Y = 85;
        final int BLOCK_SIZE = 85;
        final int FREE_SPACE = 10;

        Image lowBullet = new Image("lowBullet.png");
        Image highBullet = new Image("highBullet.png");

        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(X, Y, BLOCK_SIZE, BLOCK_SIZE);

        if (isLow){
            gc.drawImage(lowBullet, X + FREE_SPACE, Y + FREE_SPACE, BLOCK_SIZE - 2 * FREE_SPACE, BLOCK_SIZE - 2 * FREE_SPACE);
        } else {
            gc.drawImage(highBullet, X + FREE_SPACE, Y + FREE_SPACE, BLOCK_SIZE - 2 * FREE_SPACE, BLOCK_SIZE - 2 * FREE_SPACE);
        }
    }
}
