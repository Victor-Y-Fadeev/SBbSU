package sem2.hw2.task2;


public class DoublyLinkedList<DataType extends Comparable> implements List<DataType>  {
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public void add(DataType value) {
        if ((isEmpty()) || (head.value.compareTo(value) > 0)) {
            head = new Node(value, null, head);
            return;
        }

        Node temp = head;

        while ((temp.next != null) && (temp.next.value.compareTo(value) < 0)) {
            temp = temp.next;
        }

        temp.next = new Node(value, temp, temp.next);
        if (temp.next.next != null) {
            temp.next.next.prev = temp.next;

        }
    }

    public void remove(DataType value) {
        if (isEmpty()) {
            return;
        }

        if (head.value.compareTo(value) == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
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
        if (temp.next != null) {
            temp.next.prev = temp;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }


    private class Node {
        public DataType value;
        public Node prev;
        public Node next;

        public Node(DataType value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}