package sem3.hw2.task1;

/** Computer class. */
public class Computer {
    private final String OS;
    private static ComputerRandom random;
    private boolean isVirus;

    /** Create computer. */
    public Computer(final String System, ComputerRandom random) {
        isVirus = false;
        OS = System;
        this.random = random;
    }

    /** Try to infect the computer. */
    public void tryInfect() {
        if (isVirus) {
            return;
        }

        if (OS.equals("Windows")){
            isVirus = random.infectWindows();
        } else if (OS.equals("Linux")) {
            isVirus = random.infectLinux();
        } else {
            isVirus = random.infectMac();
        }
    }

    /** Infect the computer. */
    public void infect() {
        isVirus = true;
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
