package spbu.hw3.task1;


public class QuickSort<DataType extends Comparable> implements SortingAlgorithm<DataType> {
    @Override
    public void sort(DataType[] array) {
        qSort(array, 0, array.length - 1);
    }

    private void qSort(DataType[] array, int left, int right) {
        int i = left;
        int j = right;

        DataType pivot = array[(i + j) / 2];

        while (i <= j) {
            while ((array[i].compareTo(pivot) < 0)) {
                i++;
            }
            while ((array[j].compareTo(pivot) > 0)) {
                j--;
            }

            if ((i <= j) && (array[i].compareTo(array[j]) >= 0)) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (i < right) {
            qSort(array, i, right);
        }

        if (j > left) {
            qSort(array, left, j);
        }
    }

    private void swap(DataType[] array, int i, int j) {
        DataType x = array[i];

        array[i] = array[j];
        array[j] = x;
    }
}