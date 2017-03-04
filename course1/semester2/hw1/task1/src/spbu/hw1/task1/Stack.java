package spbu.hw1.task1;


public class Stack<DataType> {
    private Node head;

    public Stack() {
        head = null;
    }

    public void push(DataType value) {
        Node newNode = new Node(value, head);

        head = newNode;
    }

    public DataType pop() {
        if (isEmpty())
            return null;

        DataType value = head.value;

        head = head.next;

        return value;
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