package sem3.hw2.task2;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;

/** Test for Tree class. */
public class TreeTest {
    private final int ARRAY_SIZE = 4096;

    /** Creation test of Tree class. */
    @Test
    public void creationTest() {
        Tree<Integer> tree = new Tree<Integer>();
    }

    @Test
    public void emptyTest() {
        Tree<Integer> tree = new Tree<Integer>();

        assertTrue("Empty tree isn't empty!", tree.isEmpty());
        assertFalse("Empty tree isn't empty!", tree.find(0));
        tree.remove(0);
    }

    @Test
    public void findTest() {
        Tree<Integer> tree = new Tree<Integer>();

         Integer[] values = generateValues();

         for (int i = 0; i < values.length; i++) {
             tree.add(values[i]);
         }

        for (int i = 0; i < values.length; i++) {
            assertTrue("Element not found!", tree.find(values[i]));
        }
    }

    @Test
    public void removeTest() {
        Tree<Integer> tree = new Tree<Integer>();

        Integer[] values = generateValues();

        for (int i = 0; i < values.length; i++) {
            tree.add(values[i]);
        }

        for (int i = 0; i < values.length; i++) {
            tree.remove(values[i]);
        }

        assertTrue("Remove isn't work!", tree.isEmpty());
    }

    private Integer[] generateValues() {
        Integer[] answer = new Integer[ARRAY_SIZE];
        Random randomizer = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            answer[i] = randomizer.nextInt();
        }

        return answer;
    }
}
