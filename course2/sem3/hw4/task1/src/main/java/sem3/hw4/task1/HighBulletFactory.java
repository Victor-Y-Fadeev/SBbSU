package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;

/** High Bullet Factory. */
public class HighBulletFactory implements BulletFactory {
    @Override
    public Bullet createBullet(GraphicsContext gc, int x, int y, int fi) {
        return new HighBullet(gc, x, y, fi);
    }
}
