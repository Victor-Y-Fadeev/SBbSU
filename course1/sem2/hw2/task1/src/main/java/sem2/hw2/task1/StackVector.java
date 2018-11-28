package sem2.hw2.task1;


public class StackVector<DataType> implements Stack<DataType> {
    private Vector<DataType> vector;

    public StackVector() {
        vector = new Vector<>();
    }

    public void push(DataType value) {
        vector.add(value);
    }

    public DataType pop() {
        if (isEmpty())
            return null;

        DataType value = vector.last();

        vector.remove();

        return value;
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

}