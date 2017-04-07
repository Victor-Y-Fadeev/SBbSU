package spbu.test1.task1;


public class PriorityQueue<T> {
    private Node head;

    public PriorityQueue() {
        head = null;
    }

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

    public T dequeue() {
        if (isEmpty()){
            throw new QueueIsEmpty();
        }

        T result = head.value;
        head = head.next;
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

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