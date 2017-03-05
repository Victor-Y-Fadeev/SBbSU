package spbu.hw2.task1;

import java.util.Vector;


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

        DataType value = vector.lastElement();

        vector.remove(vector.size() - 1);

        return value;
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

}