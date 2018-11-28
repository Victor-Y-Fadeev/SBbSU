package sem2.hw2.task2;


public class SinglyLinkedList<DataType extends Comparable> implements List<DataType> {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void add(DataType value) {
        if ((isEmpty()) || (head.value.compareTo(value) > 0)) {
            head = new Node(value, head);
            return;
        }

        Node temp = head;

        while ((temp.next != null) && (temp.next.value.compareTo(value) < 0)) {
            temp = temp.next;
        }

        temp.next = new Node(value, temp.next);
    }

    public void remove(DataType value) {
        if (isEmpty()) {
            return;
        }

        if (head.value.compareTo(value) == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        while ((temp.next != null) && (temp.next.value.compareTo(value) != 0)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
    }

    public boolean isEmpty() {
        return head == null;
    }


    private class Node {
        public DataType value;
        public Node next;

        public Node(DataType value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}