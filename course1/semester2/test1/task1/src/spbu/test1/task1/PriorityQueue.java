package spbu.test1.task1;

/** PriorityQueue class. */
public class PriorityQueue<T> {
    private Node head;

    /** Create PriorityQueue class. */
    public PriorityQueue() {
        head = null;
    }

    /**
     * Add value to PriorityQueue.
     *
     * @param value     Element value
     * @param priority  Element priority
     * */
    public void enqueue(T value, int priority) {
        if ((head == null) || (head.priority < priority)) {
            head = new Node(value, priority, head);
            return;
        }

        Node temp = head;

        while ((temp.next != null) && (temp.next.priority >= priority)) {
            temp = temp.next;
        }

        temp.next = new Node(value, priority, temp.next);
    }

    /**
     * Take value from PriorityQueue.
     * Return priority value & remove it
     * from queue.
     *
     * @return  Top Element
     * */
    public T dequeue() {
        if (isEmpty()){
            throw new QueueIsEmpty();
        }

        T result = head.value;
        head = head.next;
        return result;
    }

    /** Check PriorityQueue empty. */
    public boolean isEmpty() {
        return head == null;
    }

    /** Remove from empty queue exception. */
    public static class QueueIsEmpty extends RuntimeException {
        public QueueIsEmpty() {
            super("Queue is empty!");
        }
    }

    private class Node {
        public T value;
        public int priority;
        public Node next;

        public Node(T value, int priority, Node next) {
            this.value = value;
            this.priority = priority;
            this.next = next;
        }
    }
}