package sem2.hw3.task1;


public interface SortingAlgorithm<DataType extends Comparable> {
    void sort(DataType[] array);
}