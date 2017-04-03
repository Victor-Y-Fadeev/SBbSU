package spbu.hw4.task1;


public interface List<DataType extends Comparable> {
    void add(DataType value);

    void remove(DataType value);

    public boolean isEmpty();
}