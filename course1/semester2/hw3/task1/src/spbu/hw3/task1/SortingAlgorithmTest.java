package spbu.hw3.task1;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;


public class SortingAlgorithmTest {
    private Integer[] expected;
    private Integer[] actual;

    @Before
    public void setUpSortingAlgorithm() {
        expected = new Integer[] { 1, 2, 3, 4, 5 };
        actual = new Integer[] { 5, 1, 4, 2, 3 };
    }

    @After
    public void tearDownSortingAlgorithm() {
        expected = null;
        actual = null;
    }

    @Test
    public void testInsertionSort() {
        SortingAlgorithm<Integer> testing = new InsertionSort<>();

        testing.sort(actual);

        Assert.assertEquals("This is the end, Insertion Sort doesn't work!", expected, actual);
    }
}