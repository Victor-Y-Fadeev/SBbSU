package sem3.hw3.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** The Map of Game. */
public class Map {
    private static final int width = 1360;
    private static final int height = 765;
    private static final int blockSize = 85;
    private static int[] map = {4, 3, 5, 4, 2, 2, 1, 3, 3, 3, 3, 2, 3, 3, 5, 6, 4};

    private GraphicsContext gc;
    private Image background;
    private Image ground;
    private Image groundZero;
    private Image groundUpOne;
    private Image groundUpTwo;
    private Image groundDownOne;
    private Image groundDownTwo;

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

        for (int i = 0; i < map.length - 1; i++) {
            switch (map[i + 1] - map[i]) {
                case 0:
                    gc.drawImage(ground, i * blockSize, height - blockSize * map[i]);
                    for (int j = 1; j < map[i]; j++) {
                        gc.drawImage(groundZero, i * blockSize, height - blockSize * j);
                    }
                    break;
                case 1:
                    gc.drawImage(groundUpOne, i * blockSize, height - blockSize * map[i + 1]);
                    for (int j = 1; j < map[i + 1]; j++) {
                        gc.drawImage(groundZero, i * blockSize, height - blockSize * j);
                    }
                    break;
                case 2:
                    gc.drawImage(groundUpTwo, i * blockSize, height - blockSize * map[i + 1]);
                    for (int j = 1; j < map[i + 1] - 1; j++) {
                        gc.drawImage(groundZero, i * blockSize, height - blockSize * j);
                    }
                    break;
                case -1:
                    gc.drawImage(groundDownOne, i * blockSize, height - blockSize * map[i]);
                    for (int j = 1; j < map[i]; j++) {
                        gc.drawImage(groundZero, i * blockSize, height - blockSize * j);
                    }
                    break;
                case -2:
                    gc.drawImage(groundDownTwo, i * blockSize, height - blockSize * map[i]);
                    for (int j = 1; j < map[i] - 1; j++) {
                        gc.drawImage(groundZero, i * blockSize, height - blockSize * j);
                    }
                    break;
            }
        }
    }
}
