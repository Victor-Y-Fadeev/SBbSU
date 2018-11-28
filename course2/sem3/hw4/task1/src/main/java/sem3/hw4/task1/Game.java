package sem3.hw4.task1;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import java.util.LinkedList;

/** The Game class. */
public class Game {
    private static final int CHECK_UPDATES = 5;
    private Stage primaryStage;
    private GraphicsContext gc;
    private LinkedList<String> keys;

    private Map map = new Map(gc);
    private Turret currentTurret;
    private Turret remoteTurret;
    private LinkedList<Bullet> bullets;
    private LinkedList<Bullet> newBullets;
    private BulletChanger changer;

    private Network network;
    private Transfer transfer;
    private int wait;

    /** Create Game. */
    public Game(Stage primaryStage, GraphicsContext gc, LinkedList<String> keys, Network network) {
        this.primaryStage = primaryStage;
        this.gc = gc;
        this.keys = keys;
        this.network = network;

        wait = CHECK_UPDATES;
        transfer = new Transfer();
        map = new Map(gc);

        if (network.isServer()) {
            currentTurret = new Turret(gc, 340, 0, new  LowBulletFactory(), "serverTurret.png");
            remoteTurret = new Turret(gc, 1020, 0, new  LowBulletFactory(), "clientTurret.png");
        } else {
            currentTurret = new Turret(gc, 1020, 0, new  LowBulletFactory(), "clientTurret.png");
            remoteTurret = new Turret(gc, 340, 0, new  LowBulletFactory(), "serverTurret.png");
        }

        map.putOnTheGround(currentTurret);
        map.putOnTheGround(remoteTurret);

        bullets = new LinkedList<>();
        newBullets = new LinkedList<>();
        changer = new BulletChanger(gc, currentTurret, true);
    }

    /** Start playing. */
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

                if (keys.contains("SPACE")) {
                    changer.change();
                    keys.remove("SPACE");
                }

                if (keys.contains("ENTER")) {
                    Bullet temp = currentTurret.fire();
                    bullets.add(temp);
                    newBullets.add(temp);
                    keys.remove("ENTER");
                }

                for (Bullet bullet : bullets) {
                    if (map.isOnTheGround(bullet)) {
                        bullet.explode();

                        if (turretDestroy(currentTurret, bullet)) {
                            primaryStage.close();
                            System.out.println("\nYou lose!");
                        }

                        if (turretDestroy(remoteTurret, bullet)) {
                            primaryStage.close();
                            System.out.println("\nYou win!");
                        }
                    }
                }

                cleanBullets(map, bullets);

                map.draw();
                currentTurret.draw();
                remoteTurret.draw();
                bullets.forEach(bullet -> bullet.draw());
                changer.draw();

                if (wait == 0) {
                    transfer.emitState(network.synchronization(transfer.createState()));
                    wait = CHECK_UPDATES;
                }
                wait--;
            }
        }.start();
    }

    private boolean turretDestroy(Turret turret, Bullet bullet) {
        return Math.pow(turret.getX() - bullet.getX(), 2) + Math.pow(turret.getY() - bullet.getY(), 2) < Math.pow(bullet.getRadius(), 2);
    }

    private void cleanBullets(Map map, LinkedList<Bullet> bullets) {
        LinkedList<Bullet> toRemove = new LinkedList<>();

        for (Bullet bullet : bullets) {
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
            int size = 3 + newBullets.size() * 4;
            int[] send = new int[size];

            send[0] = currentTurret.getX();
            send[1] = currentTurret.getY();
            send[2] = currentTurret.getFi();
            for (int i = 0; i < newBullets.size(); i++) {
                send[3 + i * 4] = newBullets.get(i).getType();
                send[4 + i * 4] = newBullets.get(i).getX();
                send[5 + i * 4] = newBullets.get(i).getY();
                send[6 + i * 4] = newBullets.get(i).getFi();
            }

            newBullets.clear();
            return send;
        }

        public void emitState(int[] state) {
            remoteTurret.setX(state[0]);
            remoteTurret.setY(state[1]);
            remoteTurret.setFi(state[2]);

            for (int i = 0; i < state.length - 3; i++) {
                if (state[3 + i * 4] == 0) {
                    bullets.add(new LowBullet(gc, state[4 + i * 4], state[5 + i * 4], state[6 + i * 4]));
                } else {
                    bullets.add(new HighBullet(gc, state[4 + i * 4], state[5 + i * 4], state[6 + i * 4]));
                }
            }
        }
    }
}
