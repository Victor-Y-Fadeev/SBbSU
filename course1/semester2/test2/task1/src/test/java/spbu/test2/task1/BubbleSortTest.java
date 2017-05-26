package spbu.test2.task1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.Random;

/** Test bubble sort. */
public class BubbleSortTest {
    private final int ARRAY_SIZE = 32767;
    private Integer[] array;

    /** Generate sorting array. */
    @Before
    public void setUpSortingAlgorithm() {
        Random randomizer = new Random();
        array = new Integer[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = randomizer.nextInt();
        }
    }

    /** Test usual bubble sort. */
    @Test
    public void testBubbleSort() {
        BubbleSort<Integer> testing = new BubbleSort<>();

        testing.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        });

        checkArray("Bubble sort doesn't work!", array);
    }

    /** Test bubble sort with custom comparator. */
    @Test
    public void testReverseOrderSort() {
        BubbleSort<Integer> testing = new BubbleSort<>();

        testing.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });

        checkReverseOrder("Bubble sort doesn't work with other comparator!", array);
    }

    /** Test bubble sort for Node. */
    @Test
    public void testNodeBubbleSort() {
        BubbleSort<Node> testing = new BubbleSort<>();

        Node[] array = new Node[3];
        array[0] = new Node(2, "b");
        array[1] = new Node(0, "a");
        array[2] = new Node(7, "cf");

        testing.sort(array, new Comparator<Node>() {
            @Override
            public int compare(Node s1, Node s2) {
                return s1.value.compareTo(s2.value);
            }
        });

        assertEquals("Bubble sort with Node doesn't work!", "b", array[1].string);
    }

    private void checkArray(String message, Integer[] array) {
        for (int i = 0; i < array.length - 1; i++){
            assertTrue(message, array[i].compareTo(array[i + 1]) <= 0);
        }
    }

    private void checkReverseOrder(String message, Integer[] array) {
        for (int i = array.length - 1; i > 0; i--){
            assertTrue(message, array[i].compareTo(array[i - 1]) <= 0);
        }
    }

    private class Node {
        Integer value;
        String string;

        Node(Integer value, String string) {
            this.value = value;
            this.string = string;
        }
    }
}
