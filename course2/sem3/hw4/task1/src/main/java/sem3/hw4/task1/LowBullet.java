package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** LowBullet class. */
public class LowBullet extends Bullet {
    /** Create LowBullet. */
    public LowBullet(GraphicsContext gc, int x, int y, int fi) {
        this.gc = gc;
        this.x = x;
        this.y = y;

        a = 0.005;
        bulletSize = 20;
        explodeRadius = 15;
        bullet = new Image("bullet.png");

        setFi(fi);
    }
}
