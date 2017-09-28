package sem3.hw2.task2;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/** Test for Tree class. */
public class TreeTest {
    private final int ARRAY_SIZE = 1024;

    /** Creation test of Tree class. */
    @Test
    public void creationTest() {
        Tree<Integer> tree = new Tree<Integer>();
    }

    /** Test empty tree. */
    @Test
    public void emptyTest() {
        Tree<Integer> tree = new Tree<Integer>();

        assertTrue("Empty tree isn't empty!", tree.isEmpty());
        assertFalse("Empty tree isn't empty!", tree.find(0));
        tree.remove(0);
    }

    /** Test add function. */
    @Test
    public void addTest() {
        Tree<Integer> tree = new Tree<Integer>();

        tree.add(0);

        assertFalse("Add isn't work!", tree.isEmpty());
    }

    /** Test find function. */
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

    /** Test remove function. */
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

    /** Test iterator's NoSuchElementException. */
    @Test(expected = NoSuchElementException.class)
    public void iteratorNoSuchElementExceptionTest() {
        Tree<Integer> tree = new Tree<Integer>();
        tree.add(0);

        Iterator<Integer> iterator = tree.iterator();
        iterator.next();
        iterator.next();
    }

    /** Test iterator's IllegalStateException. */
    @Test(expected = IllegalStateException.class)
    public void iteratorIllegalStateExceptionTest() {
        Tree<Integer> tree = new Tree<Integer>();
        tree.add(0);

        Iterator<Integer> iterator = tree.iterator();
        iterator.remove();
    }

    /** Test iterator's hasNext function. */
    @Test
    public void iteratorHasNextTest() {
        Tree<Integer> tree = new Tree<Integer>();
        Integer[] values = generateValues();

        Iterator<Integer> iterator = tree.iterator();

        assertFalse("Iterator's hasNext isn't work!", iterator.hasNext());
    }

    /** Test iterator's next function. */
    @Test
    public void iteratorNextTest() {
        Tree<Integer> tree = new Tree<Integer>();
        Integer[] values = generateValues();

        for (int i = 0; i < values.length; i++) {
            tree.add(values[i]);
        }

        Iterator<Integer> iterator = tree.iterator();

        int buff = iterator.next();
        for (int i = 0; i < values.length - 1; i++) {
            int temp = iterator.next();

            assertTrue("Iterator's consequence broken!", buff <= temp);

            buff = temp;
        }
    }

    /** Test iterator's remove function. */
    @Test
    public void iteratorRemoveTest() {
        Tree<Integer> tree = new Tree<Integer>();
        Integer[] values = generateValues();

        for (int i = 0; i < values.length; i++) {
            tree.add(values[i]);
        }

        Iterator<Integer> iterator = tree.iterator();

        for (int i = 0; i < values.length; i++) {
            iterator.next();
            iterator.remove();
        }

        assertTrue("Iterator's remove isn't work!", tree.isEmpty());
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
