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
}
