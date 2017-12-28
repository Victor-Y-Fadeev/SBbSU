package sem3.hw4.task1;

import javafx.scene.canvas.GraphicsContext;

public interface BulletFactory {
    public Bullet createBullet(GraphicsContext gc, int x, int y, int fi);
}
