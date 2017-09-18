package sem3.hw2.task1;

import java.util.Random;

/** Computer class. */
public class Computer {
    public final String OS;
    public boolean isVirus;
    private static final double WINDOWS = 0.7;
    private static final double LINUX = 0.1;
    private static final double MAC = 0.3;
    private final double DEFECT;

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

    public void tryInfect() {
        //Rundom rundomizer = new Rundom();
    }
}
