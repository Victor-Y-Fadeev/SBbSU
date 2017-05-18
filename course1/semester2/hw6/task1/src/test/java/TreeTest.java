import static org.junit.Assert.*;
import spbu.hw6.task1.Tree;
import org.junit.Test;
import java.io.*;

/** Tree test class. */
public class TreeTest {
    /** Creation test. */
    @Test
    public void testCreationTree() {
        createFile("(* (+ 1 1) 2)");
        Tree tree = new Tree("input.txt");
    }

    /** Basic test. */
    @Test
    public void testBasicExpression() {
        createFile("(* (+ 1 1) 2)");
        Tree tree = new Tree("input.txt");

        assertEquals("Incorrect arithmetic expression", "(* (+ 1 1) 2)", tree.output());
        assertEquals("Incorrect calculating", 4, tree.calculate());
    }

    /** Plus test. */
    @Test
    public void testPlusExpression() {
        createFile("(+ 3 3)");
        Tree tree = new Tree("input.txt");

        assertEquals("Incorrect arithmetic expression", "(+ 3 3)", tree.output());
        assertEquals("Incorrect calculating", 6, tree.calculate());
    }

    /** Minus test. */
    @Test
    public void testMinusExpression() {
        createFile("(- 4 4)");
        Tree tree = new Tree("input.txt");

        assertEquals("Incorrect arithmetic expression", "(- 4 4)", tree.output());
        assertEquals("Incorrect calculating", 0, tree.calculate());
    }

    /** Multiply test. */
    @Test
    public void testMultiplyExpression() {
        createFile("(* 5 5)");
        Tree tree = new Tree("input.txt");

        assertEquals("Incorrect arithmetic expression", "(* 5 5)", tree.output());
        assertEquals("Incorrect calculating", 25, tree.calculate());
    }

    /** Divide test. */
    @Test
    public void testDivideExpression() {
        createFile("(/ 6 6)");
        Tree tree = new Tree("input.txt");

        assertEquals("Incorrect arithmetic expression", "(/ 6 6)", tree.output());
        assertEquals("Incorrect calculating", 1, tree.calculate());
    }


    private void createFile(String toWrite) {
        try(FileWriter writer = new FileWriter("input.txt")) {
            writer.write(toWrite);
            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
