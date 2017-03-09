package spbu.hw2.task2;


public interface List<DataType extends Comparable> {
    void add(DataType value);

    void remove(DataType value);

    public boolean isEmpty();
}