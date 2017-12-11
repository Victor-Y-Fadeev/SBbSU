package sem3.hw2.task1;

/** Main class. */
public class Main {
    /** Main method. */
    public static void main(String[] args) {
        Network network = new Network("input.txt", new InfectRandom());

        System.out.println(network.getStructure());
        System.out.println(network.getStatus());

        for (int i = 0; i < 10; i++) {
            network.timeGoes();
            System.out.println(network.getStatus());
        }
    }
}
