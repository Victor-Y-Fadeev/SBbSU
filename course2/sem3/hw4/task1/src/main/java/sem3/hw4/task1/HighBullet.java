package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** HighBullet class. */
public class HighBullet extends Bullet {
    /** Create HighBullet. */
    public HighBullet(GraphicsContext gc, int x, int y, int fi) {
        this.gc = gc;
        this.x = x;
        this.y = y;

        a = 0.008;
        bulletSize = 15;
        explodeRadius = 25;
        bullet = new Image("highBullet.png");

        setFi(fi);
    }

    @Override
    public int getType() {
        return 1;
    }
}
