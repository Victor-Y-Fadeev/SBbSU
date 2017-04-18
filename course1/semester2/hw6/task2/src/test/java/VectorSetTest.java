import static org.junit.Assert.*;
import spbu.hw6.task2.VectorSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/** Tests for VectorSet class. */
public class VectorSetTest {
    /** Creation test. */
    @Test
    public void testCreationtVectorSet() {
        VectorSet<Integer> set = new VectorSet<>();
    }

    /** Test add() function. */
    @Test
    public void testAdd() {
        VectorSet<Integer> set = new VectorSet<>();

        assertTrue("Error with add() function!", set.add(5));
        assertFalse("Incorrect repeat called add() function!", set.add(5));

        set.remove(5);
        assertTrue("Error with remove() after called add()!", set.isEmpty());
    }

    /** Test  addAll() function. */
    @Test
    public void testAddAll() {
        VectorSet<Integer> set = new VectorSet<>();

        Collection<Integer> collection = getCollection(new int[]{1, 2, 2, 4});

        assertTrue("Error with addAll() function!", set.addAll(collection));
        assertFalse("Incorrect repeat called addAll() function!", set.addAll(collection));

        set.remove(2);
        Collection<Integer> collection2 = getCollection(new int[]{1, 4});
        assertFalse("Error with remove() after called addAll()!", set.addAll(collection2));

    }

    private Collection<Integer> getCollection(int[] mas) {
        Collection<Integer> collection = new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            collection.add(mas[i]);
        }

        return collection;
    }
}