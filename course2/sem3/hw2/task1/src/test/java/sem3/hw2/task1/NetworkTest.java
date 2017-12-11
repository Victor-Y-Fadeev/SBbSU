package sem3.hw2.task1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import java.io.*;

/** Test for Network class. */
public class NetworkTest {
    /** Creation test of Network class. */
    @Test
    public void creationTest() {
        Network network = new Network("input.txt", new InfectRandom());
    }

    /** Consistently Network test. */
    @Test
    public void consistentlyTest() {
        generateConsistently();
        Network network = new Network("consistently.txt", new InfectRandom());

        String[] config = network.getStatus().split("\n");
        assertTrue("Inconsistently infection error!", isVirus(config[0]) && !isVirus(config[1]) && !isVirus(config[2]));

        while (!isVirus(config[1])) {
            network.timeGoes();
            config = network.getStatus().split("\n");
        }
        assertTrue("Inconsistently infection error!", isVirus(config[0]) && isVirus(config[1]) && !isVirus(config[2]));
    }

    /** Parallel Network test. */
    @Test
    public void parallelTest() {
        generateParallel();
        Network network = new Network("parallel.txt", new InfectRandom());

        String[] config = network.getStatus().split("\n");
        assertTrue("Teleport infection error!", isVirus(config[0]) && !isVirus(config[1]) && !isVirus(config[2])&& !isVirus(config[3])&& !isVirus(config[4])&& !isVirus(config[5]));

        while (!isVirus(config[4]) || !isVirus(config[5])) {
            network.timeGoes();
            config = network.getStatus().split("\n");

            if (isVirus(config[3])) {
                assertTrue("Teleport infection error!", isVirus(config[2]));
            }

            if (isVirus(config[4])) {
                assertTrue("Teleport infection error!", isVirus(config[3]) && isVirus(config[2]));
            }

            if (isVirus(config[5])) {
                assertTrue("Teleport infection error!", isVirus(config[1]));
            }
        }
    }

    /** Consistently Network test using hard infection. */
    @Test
    public void hardConsistentlyTest() {
        generateConsistently();
        Network network = new Network("consistently.txt", new HardRandom());

        String[] config = network.getStatus().split("\n");
        assertTrue("Inconsistently infection error!", isVirus(config[0]) && !isVirus(config[1]) && !isVirus(config[2]));

        network.timeGoes();
        config = network.getStatus().split("\n");
        assertTrue("Inconsistently infection error!", isVirus(config[0]) && isVirus(config[1]) && !isVirus(config[2]));

        network.timeGoes();
        config = network.getStatus().split("\n");
        assertTrue("Inconsistently infection error!", isVirus(config[0]) && isVirus(config[1]) && isVirus(config[2]));
    }

    /** Parallel Network test using hard infection. */
    @Test
    public void hardParallelTest() {
        generateParallel();
        Network network = new Network("parallel.txt", new HardRandom());

        String[] config = network.getStatus().split("\n");
        assertTrue("Teleport infection error!", isVirus(config[0]) && !isVirus(config[1]) && !isVirus(config[2])&& !isVirus(config[3])&& !isVirus(config[4])&& !isVirus(config[5]));

        network.timeGoes();
        config = network.getStatus().split("\n");
        assertTrue("Teleport infection error!", isVirus(config[0]) && isVirus(config[1]) && isVirus(config[2])&& !isVirus(config[3])&& !isVirus(config[4])&& !isVirus(config[5]));

        network.timeGoes();
        config = network.getStatus().split("\n");
        assertTrue("Teleport infection error!", isVirus(config[0]) && isVirus(config[1]) && isVirus(config[2])&& isVirus(config[3])&& !isVirus(config[4])&& isVirus(config[5]));

        network.timeGoes();
        config = network.getStatus().split("\n");
        assertTrue("Teleport infection error!", isVirus(config[0]) && isVirus(config[1]) && isVirus(config[2])&& isVirus(config[3])&& isVirus(config[4])&& isVirus(config[5]));
    }

    /** Clean test inputs. */
    @After
    public void filesRemoving() {
        File file = new File("consistently.txt");
        file.delete();

        file = new File("parallel.txt");
        file.delete();
    }

    private boolean isVirus(String computer) {
        return computer.length() >= 14;
    }

    private void generateConsistently() {
        try(FileWriter writer = new FileWriter("consistently.txt")) {
            BufferedWriter out = new BufferedWriter(writer);

            out.write("3\nWindows\nMac OS\nLinux\n\n");
            out.write("1\n\n");
            out.write("2\n1 2\n2 3\n");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateParallel() {
        try(FileWriter writer = new FileWriter("parallel.txt")) {
            BufferedWriter out = new BufferedWriter(writer);

            out.write("6\nWindows\nWindows\nWindows\nLinux\nLinux\nMac OS\n\n");
            out.write("1\n\n");
            out.write("6\n1 2\n1 3\n2 3\n2 6\n3 4\n4 5\n");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class HardRandom implements ComputerRandom {
        @Override
        public boolean infectWindows() {
            return true;
        }

        @Override
        public boolean infectLinux() {
            return true;
        }

        @Override
        public boolean infectMac() {
            return true;
        }
    }
}
