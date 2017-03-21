package spbu.hw4.task1;


public class UniqueList<DataType extends Comparable> extends SinglyLinkedList<DataType> implements List<DataType> {
    public UniqueList() {
        super();
    }

    @Override
    public void add(DataType value) {
        if ((isEmpty()) || (head.value.compareTo(value) > 0)) {
            head = new Node(value, head);
            return;
        }

        if (head.value.compareTo(value) == 0) {
            throw new ElementAlreadyExists();
        }

        Node temp = head;

        while ((temp.next != null) && (temp.next.value.compareTo(value) < 0)) {
            temp = temp.next;
        }

        if ((temp.next != null) && (temp.next.value.compareTo(value) == 0)) {
            throw new ElementAlreadyExists();
        }

        temp.next = new Node(value, temp.next);
    }

    @Override
    public void remove(DataType value) {
        if (isEmpty()) {
            throw new ElementNotFound();
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
            throw new ElementNotFound();
        }

        temp.next = temp.next.next;
    }

    public static class ElementAlreadyExists extends RuntimeException {
        public ElementAlreadyExists() {
            super("Element already exists!");
        }
    }

    public static class ElementNotFound extends RuntimeException {
        public ElementNotFound() {
            super("Element not found!");
        }
    }
}