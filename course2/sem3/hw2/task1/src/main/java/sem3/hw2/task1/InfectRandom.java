package sem3.hw2.task1;

import java.util.Random;

/** Random class for computers infections. */
public class InfectRandom implements ComputerRandom {
    private static final double WINDOWS = 0.7;
    private static final double LINUX = 0.1;
    private static final double MAC = 0.3;
    private static Random random;

    /** Create random. */
    public InfectRandom(){
        random = new Random();
    }

    @Override
    public boolean infectWindows() {
        return random.nextDouble() < WINDOWS;
    }

    @Override
    public boolean infectLinux() {
        return random.nextDouble() < LINUX;
    }

    @Override
    public boolean infectMac() {
        return random.nextDouble() < MAC;
    }
}
