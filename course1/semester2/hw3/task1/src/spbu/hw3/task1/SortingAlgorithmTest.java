package spbu.hw3.task1;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import java.util.Random;


public class SortingAlgorithmTest {
    private final int ARRAY_SIZE = 32767;
    private Integer[] testingArray;

    @Before
    public void setUpSortingAlgorithm() {
        Random randomizer = new Random();
        testingArray = new Integer[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            testingArray[i] = randomizer.nextInt();
        }
    }

    @After
    public void tearDownSortingAlgorithm() {
        testingArray = null;
    }

    @Test
    public void testInsertionSort() {
        SortingAlgorithm<Integer> testing = new InsertionSort<>();

        testing.sort(testingArray);

        checkArray("This is the end, Insertion Sort doesn't work!", testingArray);
    }

    @Test
    public void testQuickSort() {
        SortingAlgorithm<Integer> testing = new QuickSort<>();

        testing.sort(testingArray);

        checkArray("We have some problems with Quick Sort", testingArray);
    }

    private void checkArray(String message, Integer[] array) {
        for (int i = 0; i < array.length - 1; i++){
            Assert.assertTrue(message, array[i].compareTo(array[i + 1]) <= 0);
        }
    }
}