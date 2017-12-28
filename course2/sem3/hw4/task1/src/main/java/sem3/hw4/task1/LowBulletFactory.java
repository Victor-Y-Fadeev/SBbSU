package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;

/** Low Bullet Factory. */
public class LowBulletFactory implements BulletFactory {
    @Override
    public Bullet createBullet(GraphicsContext gc, int x, int y, int fi) {
        return new LowBullet(gc, x, y, fi);
    }
}
