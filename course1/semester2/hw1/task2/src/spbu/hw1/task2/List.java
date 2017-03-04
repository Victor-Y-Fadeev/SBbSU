package spbu.hw1.task2;


public class List<DataType extends Comparable> {
    private Node head;

    public List() {
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
        if (isEmpty())
            return;

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
        DataType value;
        Node next;

        Node(DataType value, Node next){

            this.value = value;
            this.next = next;
        }
    }
}