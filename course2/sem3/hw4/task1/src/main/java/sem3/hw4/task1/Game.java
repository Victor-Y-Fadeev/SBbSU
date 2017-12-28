package sem3.hw4.task1;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import java.util.LinkedList;

public class Game {
    private Stage primaryStage;
    private GraphicsContext gc;
    private LinkedList<String> keys;

    private Map map = new Map(gc);
    private Turret currentTurret;
    private Turret remoteTurret;
    private LinkedList<Bullet> bullets;
    private LinkedList<Bullet> newBullets;

    private Network network;
    private Transfer transfer;

    public Game(Stage primaryStage, GraphicsContext gc, LinkedList<String> keys, Network network) {
        this.primaryStage = primaryStage;
        this.gc = gc;
        this.keys = keys;
        this.network = network;

        transfer = new Transfer();
        map = new Map(gc);

        if (network.isServer()) {
            currentTurret = new Turret(gc, 340, 0);
            remoteTurret = new Turret(gc, 1020, 0);
        } else {
            currentTurret = new Turret(gc, 1020, 0);
            remoteTurret = new Turret(gc, 340, 0);
        }

        map.putOnTheGround(currentTurret);
        map.putOnTheGround(remoteTurret);

        bullets = new LinkedList<>();
        newBullets = new LinkedList<>();
    }

    public void play() {
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (keys.contains("ESCAPE")) {
                    primaryStage.close();
                }

                if (keys.contains("LEFT")) {
                    currentTurret.setX(currentTurret.getX() - 1);
                    map.putOnTheGround(currentTurret);
                }

                if (keys.contains("RIGHT")) {
                    currentTurret.setX(currentTurret.getX() + 1);
                    map.putOnTheGround(currentTurret);
                }

                if (keys.contains("UP")) {
                    currentTurret.gunUp();
                }

                if (keys.contains("DOWN")) {
                    currentTurret.gunDown();
                }

                if (keys.contains("ENTER")) {
                    Bullet temp = currentTurret.fire();
                    bullets.add(temp);
                    newBullets.add(temp);
                    keys.remove("ENTER");
                }

                cleanBullets(map, bullets);

                map.draw();
                currentTurret.draw();
                remoteTurret.draw();
                bullets.forEach(bullet -> bullet.draw());

                transfer.emitState(network.synchronization(transfer.createState()));
            }
        }.start();
    }

    private void cleanBullets(Map map, LinkedList<Bullet> bullets) {
        LinkedList<Bullet> toRemove = new LinkedList<>();

        for (Bullet bullet : bullets) {
            if (map.isOnTheGround(bullet)) {
                bullet.explode();
            }

            if (bullet.isExploded()) {
                toRemove.add(bullet);
            }
        }

        for (Bullet bullet : toRemove) {
            bullets.remove(bullet);
        }
    }

    private class Transfer {
        public int[] createState() {
            int size = 3 + newBullets.size() * 3;
            int[] send = new int[size];

            send[0] = currentTurret.getX();
            send[1] = currentTurret.getY();
            send[2] = currentTurret.getFi();

            for (int i = 0; i < newBullets.size(); i++) {
                send[3 + i * 3] = newBullets.get(i).getX();
                send[4 + i * 3] = newBullets.get(i).getY();
                send[5 + i * 3] = newBullets.get(i).getFi();
            }

            newBullets.clear();
            return send;
        }

        public void emitState(int[] state) {
            remoteTurret.setX(state[0]);
            remoteTurret.setY(state[1]);
            remoteTurret.setFi(state[2]);

            for (int i = 0; i < state.length; i++) {
                bullets.add(new Bullet(gc, state[3 + i * 3], state[4 + i * 3], state[5 + i * 3]));
            }
        }
    }
}
