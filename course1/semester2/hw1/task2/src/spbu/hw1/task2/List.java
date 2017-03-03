package spbu.hw1.task2;


public class List<DataType extends Comparable> {

    private Node top;

    public List() {

        top = null;
    }

    public void add(DataType value) {

        if ((emptyList()) || (top.getValue().compareTo(value) > 0)) {
            top = new Node(value, top);
            return;
        }

        Node temp = top;

        while ((temp.getNext() != null) && (temp.getNext().getValue().compareTo(value) < 0)) {
            temp = temp.getNext();
        }

        temp.changeNext(new Node(value, temp.getNext()));
    }

    public void remove(DataType value) {

        if (emptyList())
            return;

        if (top.getValue().compareTo(value) == 0) {
            top = top.getNext();
            return;
        }

        Node temp = top;

        while ((temp.getNext() != null) && (temp.getNext().getValue().compareTo(value) != 0)) {
            temp = temp.getNext();
        }

        if (temp.getNext() == null) {
            return;
        }

        temp.changeNext(temp.getNext().getNext());
    }

    public boolean emptyList() {

        return (top == null);
    }


    private class Node {

        private DataType value;

        private Node next;

        public Node(DataType value, Node next){

            this.value = value;
            this.next = next;
        }

        public void changeNext(Node next){

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