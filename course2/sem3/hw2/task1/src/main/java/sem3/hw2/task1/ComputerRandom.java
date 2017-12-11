package sem3.hw2.task1;

/** Random interface for computers. */
public interface ComputerRandom {
    /** Try to infect Windows computer. */
    boolean infectWindows();
    /** Try to infect Linux computer. */
    boolean infectLinux();
    /** Try to infect Mac computer. */
    boolean infectMac();
}
