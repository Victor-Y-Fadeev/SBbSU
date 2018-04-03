package sem3.hw3.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** The Map of Game. */
public class Map {
    private static final int HEIGHT = 765;
    private static final int BLOCK_SIZE = 85;
    private static final int[] MAP = {4, 3, 5, 4, 2, 2, 1, 3, 3, 3, 3, 2, 3, 3, 5, 6, 4};

    private final GraphicsContext gc;
    private final Image background;
    private final Image ground;
    private final Image groundZero;
    private final Image groundUpOne;
    private final Image groundUpTwo;
    private final Image groundDownOne;
    private final Image groundDownTwo;

    /** Create Map. */
    public Map(GraphicsContext gc) {
        this.gc = gc;

        background = new Image("background.png");
        ground = new Image("ground.png");
        groundZero = new Image("groundZero.png");
        groundUpOne = new Image("groundUpOne.png");
        groundUpTwo = new Image("groundUpTwo.png");
        groundDownOne = new Image("groundDownOne.png");
        groundDownTwo = new Image("groundDownTwo.png");
    }

    /** Draw Map. */
    public void draw() {
        gc.drawImage(background, 0, 0);

        for (int i = 0; i < MAP.length - 1; i++) {
            switch (MAP[i + 1] - MAP[i]) {
                case 0:
                    gc.drawImage(ground, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * MAP[i]);
                    for (int j = 1; j < MAP[i]; j++) {
                        gc.drawImage(groundZero, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * j);
                    }
                    break;
                case 1:
                    gc.drawImage(groundUpOne, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * MAP[i + 1]);
                    for (int j = 1; j < MAP[i + 1]; j++) {
                        gc.drawImage(groundZero, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * j);
                    }
                    break;
                case 2:
                    gc.drawImage(groundUpTwo, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * MAP[i + 1]);
                    for (int j = 1; j < MAP[i + 1] - 1; j++) {
                        gc.drawImage(groundZero, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * j);
                    }
                    break;
                case -1:
                    gc.drawImage(groundDownOne, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * MAP[i]);
                    for (int j = 1; j < MAP[i]; j++) {
                        gc.drawImage(groundZero, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * j);
                    }
                    break;
                case -2:
                    gc.drawImage(groundDownTwo, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * MAP[i]);
                    for (int j = 1; j < MAP[i] - 1; j++) {
                        gc.drawImage(groundZero, i * BLOCK_SIZE, HEIGHT - BLOCK_SIZE * j);
                    }
                    break;
            }
        }
    }

    /** Put object on the ground. */
    public void putOnTheGround(Coordinate obj) {
        obj.setY(getGroundY(obj.getX()));
    }

    /** Check object location. */
    public boolean isOnTheGround(Coordinate obj) {
        return obj.getY() > getGroundY(obj.getX());
    }

    private int getGroundY(int x) {
        final int blockNumber = x / BLOCK_SIZE;
        int y = HEIGHT - MAP[blockNumber] * BLOCK_SIZE;

        switch (MAP[blockNumber + 1] - MAP[blockNumber]) {
            case 1:
                y -= x - blockNumber * BLOCK_SIZE;
                break;
            case -1:
                y += x - blockNumber * BLOCK_SIZE;
                break;
            case 2:
                y -= 2 * (x - blockNumber * BLOCK_SIZE);
                break;
            case -2:
                y += 2 * (x - blockNumber * BLOCK_SIZE);
                break;

        }

        return y;
    }
}
