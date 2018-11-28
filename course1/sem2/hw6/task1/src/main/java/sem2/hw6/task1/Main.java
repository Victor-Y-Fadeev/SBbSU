package sem2.hw6.task1;

/** Main class.*/
public class Main {
    /** Main method. */
    public static void main(String[] args) {
        Tree tree = new Tree("input.txt");

        System.out.print(tree.output());
        System.out.print(" = ");
        System.out.println(tree.calculate());
    }
}