import static org.junit.Assert.*;
import spbu.hw6.task2.VectorSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/** Tests for VectorSet class. */
public class VectorSetTest {
    /** Creation test. */
    @Test
    public void testCreationVectorSet() {
        VectorSet<Integer> set = new VectorSet<>();
    }

    /** Test size() function. */
    @Test
    public void testSize() {
        VectorSet<Integer> set = new VectorSet<>();

        Collection<Integer> collection = getCollection(new int[]{5, 7, 10});
        set.addAll(collection);

        assertEquals("Error with size() function!", 3, set.size());
    }

    /** Test isEmpty() function. */
    @Test
    public void testIsEmpty() {
        VectorSet<Integer> set = new VectorSet<>();

        assertTrue("Error with isEmpty() function!", set.isEmpty());
    }

    /** Test contains() function. */
    @Test
    public void testContains() {
        VectorSet<Integer> set = new VectorSet<>();

        set.add(5);

        assertTrue("Error with contains() function!", set.contains(5));
    }

    /** Test iterator() function. */
    @Test
    public void testIterator() {
        VectorSet<Integer> set = new VectorSet<>();

        set.add(5);
        Iterator<Integer> iterator = set.iterator();

        assertEquals("Error with iterator() function!", new Integer(5), iterator.next());
    }

    /** Test toArray() function. */
    @Test
    public void testToArray() {
        VectorSet<Integer> set = new VectorSet<>();

        Collection<Integer> collection = getCollection(new int[]{5, 7, 10});
        set.addAll(collection);

        assertEquals("Error with toArray() function!", new Integer[]{5, 7, 10}, set.toArray());
        assertEquals("Error with toArray(T[]) function!", new Integer[]{5, 7, 10}, set.toArray(new Integer[3]));
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

    /** Test remove() function. */
    @Test
    public void testRemove() {
        VectorSet<Integer> set = new VectorSet<>();

        set.add(5);
        set.remove(5);

        assertTrue("Error with remove() function!", set.isEmpty());
    }

    /** Test containsAll() function. */
    @Test
    public void testContainsAll() {
        VectorSet<Integer> set = new VectorSet<>();

        Collection<Integer> collection = getCollection(new int[]{5, 7, 10});
        set.addAll(collection);

        assertTrue("Error with containsAll() function!", set.containsAll(collection));
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

    /** Test retainAll() function. */
    @Test
    public void testRetainAll() {
        VectorSet<Integer> set = new VectorSet<>();

        Collection<Integer> collection = getCollection(new int[]{5, 7, 10, 14});
        set.addAll(collection);
        collection = getCollection(new int[]{5, 7, 10});
        set.retainAll(collection);

        assertTrue("Error with retainAll() function!", !set.contains(14) && set.containsAll(collection));
    }

    /** Test removeAll() function. */
    @Test
    public void testRemoveAll() {
        VectorSet<Integer> set = new VectorSet<>();

        Collection<Integer> collection = getCollection(new int[]{5, 7, 10});
        set.addAll(collection);
        set.removeAll(collection);

        assertTrue("Error with removeAll() function!", set.isEmpty());
    }

    /** Test clear() function. */
    @Test
    public void testClear() {
        VectorSet<Integer> set = new VectorSet<>();

        Collection<Integer> collection = getCollection(new int[]{5, 7, 10});
        set.addAll(collection);
        set.clear();

        assertTrue("Error with clear() function!", set.isEmpty());
    }

    private Collection<Integer> getCollection(int[] mas) {
        Collection<Integer> collection = new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            collection.add(mas[i]);
        }

        return collection;
    }
}