package spbu.hw2.task1;


public interface Stack<DataType>  {
    void push(DataType value);

    DataType pop();

    boolean isEmpty();
}