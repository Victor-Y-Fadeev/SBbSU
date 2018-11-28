package sem2.hw4.task2;


public class UniqueList<DataType extends Comparable> {
    private Node head;
    private int size;

    public UniqueList() {
        head = null;
        size = 0;
    }

    public void add(DataType value) {
        if ((isEmpty()) || (head.value.compareTo(value) > 0)) {
            head = new Node(value, head);
            size++;
            return;
        }

        if (head.value.compareTo(value) == 0) {
            return;
        }

        Node temp = head;

        while ((temp.next != null) && (temp.next.value.compareTo(value) < 0)) {
            temp = temp.next;
        }

        if ((temp.next != null) && (temp.next.value.compareTo(value) == 0)) {
            return;
        }

        temp.next = new Node(value, temp.next);
        size++;
    }

    public void remove(DataType value) {
        if (isEmpty()) {
            return;
        }

        if (head.value.compareTo(value) == 0) {
            head = head.next;
            size--;
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
        size--;
    }

    public boolean isExists(DataType value) {
        if (isEmpty()) {
            return false;
        }

        Node temp = head;
        while ((temp != null) && (temp.value.compareTo(value) != 0)) {
            temp = temp.next;
        }

        return temp != null;
    }

    public DataType getFirst() {
        if (isEmpty()) {
            return null;
        }

        DataType temp = head.value;
        head = head.next;
        size--;
        return temp;
    }

    public int getSize() {
        return size;
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