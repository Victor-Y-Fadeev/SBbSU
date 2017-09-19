package sem3.hw2.task1;

import java.util.Random;

/** Computer class. */
public class Computer {
    private static final double WINDOWS = 0.7;
    private static final double LINUX = 0.1;
    private static final double MAC = 0.3;
    private final double DEFECT;
    private final String OS;
    private boolean isVirus;

    /** Create computer. */
    public Computer(String System) {
        isVirus = false;
        OS = System;

        if (OS.equals("Windows")){
            DEFECT = WINDOWS;
        } else if (OS.equals("Linux")) {
            DEFECT = LINUX;
        } else {
            DEFECT = MAC;
        }
    }

    /** Try to infect the computer. */
    public void tryInfect() {
        Random random = new Random();

        if (random.nextDouble() < DEFECT) {
            isVirus = true;
        }
    }

    /** Get computer's OS. */
    public String getOS() {
        return OS;
    }

    /** Check computer's viruses. */
    public boolean isVirus() {
        return isVirus;
    }
}
