package sem2.hw4.task2;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import java.util.Random;

public class HashTableTest {
    private final int ARRAY_SIZE = 512;
    private final int STEP_SIZE = 64;
    private Integer[] testArray;

    @Before
    public void setUpSortingAlgorithm() {
        Random randomizer = new Random();
        testArray = new Integer[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            testArray[i] = STEP_SIZE * i + randomizer.nextInt(STEP_SIZE - 1);
        }
    }

    @After
    public void tearDownSortingAlgorithm() {
        testArray = null;
    }

    @Test
    public void testFirstHasher() {
        testHashTable(new FirstHashFunction());
    }

    @Test
    public void testSecondHasher() {
        testHashTable(new SecondHashFunction());
    }

    private void testHashTable(Hasher hasher) {
        HashTable<Integer> testTable = new HashTable<>(hasher);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            testTable.add(testArray[i]);
            Assert.assertTrue("We have problem with add() function!", testTable.isExists(testArray[i]));
        }

        for (int i = 0; i < ARRAY_SIZE; i++) {
            testTable.remove(testArray[i]);
            Assert.assertTrue("We have problem with remove() function!", !testTable.isExists(testArray[i]));
        }
    }
}
