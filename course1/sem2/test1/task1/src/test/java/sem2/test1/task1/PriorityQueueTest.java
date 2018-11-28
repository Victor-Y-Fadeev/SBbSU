package sem2.test1.task1;

import org.junit.Test;
import static org.junit.Assert.*;

/** Test class for PriorityQueue. */
public class PriorityQueueTest {
    /** Test creation PriorityQueue. */
    @Test
    public void testPriorityQueueCreation() {
        PriorityQueue<Integer> test = new PriorityQueue<>();
    }

    /** Test PriorityQueue<Integer>. */
    @Test
    public void testIntegerPriorityQueue() {
        PriorityQueue<Integer> test = new PriorityQueue<>();

        test.enqueue(5, 5);
        test.enqueue(2, 2);
        test.enqueue(4, 4);
        test.enqueue(7, 7);
        test.enqueue(0, 2);

        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals(7));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals(5));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals(4));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals(2));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals(0));
    }

    /** Test PriorityQueue<String>. */
    @Test
    public void testStringPriorityQueue() {
        PriorityQueue<String> test = new PriorityQueue<>();

        test.enqueue("5", 5);
        test.enqueue("2", 2);
        test.enqueue("4", 4);
        test.enqueue("7", 7);
        test.enqueue("0", 2);

        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals("7"));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals("5"));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals("4"));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals("2"));
        assertTrue("Error in PriorityQueue<Integer>", test.dequeue().equals("0"));
    }

    /** Test isEmpty() function. */
    @Test
    public void testPriorityQueueIsEmpty() {
        PriorityQueue<Integer> test = new PriorityQueue<>();
        assertTrue("Error in isEmpty function!", test.isEmpty());
    }

    /** Test dequeue() function exception. */
    @Test(expected = PriorityQueue.QueueIsEmpty.class)
    public void testPriorityQueueException() {
        PriorityQueue<Integer> test = new PriorityQueue<>();
        test.dequeue();
    }
}