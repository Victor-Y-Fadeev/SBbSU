package spbu.hw2.task1;


public class StackList<DataType> implements Stack<DataType> {
    private Node head;

    public StackList() {
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
        public DataType value;
        public Node next;

        public Node(DataType value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}