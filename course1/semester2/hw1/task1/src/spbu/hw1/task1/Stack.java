package spbu.hw1.task1;


public class Stack<DataType> {

    private Node top;

    public Stack() {

        top = null;
    }

    public void push(DataType value) {

        Node newNode = new Node(value, top);

        top = newNode;
    }

    public DataType pop() {

        if (emptyStack())
            return null;

        DataType value = top.getValue();

        top = top.getNext();

        return value;
    }

    public boolean emptyStack() {

        return (top == null);
    }


    private class Node {

        private DataType value;

        private Node next;

        public Node(DataType value, Node next){

            this.value = value;
            this.next = next;
        }

        public DataType getValue() {

            return value;
        }

        public Node getNext() {

            return next;
        }
    }
}