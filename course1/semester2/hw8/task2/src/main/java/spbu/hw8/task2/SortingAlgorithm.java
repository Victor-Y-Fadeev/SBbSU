package spbu.hw8.task2;

/** Sorting Algorithms interface. */
public interface SortingAlgorithm<T extends Comparable> {
    /** Sorting function. */
    void sort(T[] array);
}