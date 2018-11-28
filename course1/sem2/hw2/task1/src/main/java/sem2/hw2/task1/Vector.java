package sem2.hw2.task1;


public class Vector<DataType> {
    private final int INITIAL_SIZE = 10;

    private DataType array[];
    private int size;
    private int elements;

    public Vector() {
        Object temp[] = new Object[INITIAL_SIZE];
        array = (DataType[]) temp;

        size = INITIAL_SIZE;
        elements = 0;
    }

    public void add(DataType element) {
        if (size == elements) {
            resize();
        }

        array[elements] = element;
        elements++;
    }

    public void remove() {
        elements--;
    }

    public DataType last() {
        if (isEmpty()) {
            return null;
        } else {
            return array[elements - 1];
        }
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    private void resize() {
        Object temp[] = new Object[size * 2];
        DataType newArray[] = (DataType[]) temp;

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        size *= 2;
        array = newArray;
    }
}