package sem2.hw4.task1;


public class UniqueList<DataType extends Comparable> extends SinglyLinkedList<DataType> implements List<DataType> {
    public UniqueList() {
        super();
    }

    @Override
    public void add(DataType value) {
        if (isExists(value)) {
            throw new ElementAlreadyExists();
        }

        super.add(value);
    }

    @Override
    public void remove(DataType value) {
        if (!isExists(value)) {
            throw new ElementNotFound();
        }

        super.remove(value);
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