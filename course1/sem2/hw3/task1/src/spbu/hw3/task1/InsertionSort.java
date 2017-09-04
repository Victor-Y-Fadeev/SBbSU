package spbu.hw3.task1;


public class InsertionSort<DataType extends Comparable> implements SortingAlgorithm<DataType> {
    @Override
    public void sort(DataType[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;

            while ((j > 0) && (array[j].compareTo(array[j - 1]) < 0)){
                swap(array, j);
                j = j - 1;
            }

        }
    }

    private void swap(DataType[] array, int element) {
        DataType x = array[element];

        array[element] = array[element - 1];
        array[element - 1] = x;
    }
}