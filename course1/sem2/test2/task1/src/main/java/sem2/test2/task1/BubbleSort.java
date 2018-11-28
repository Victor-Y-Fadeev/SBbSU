package sem2.test2.task1;

import java.util.Comparator;

/** Bubble sort with comparator. */
public class BubbleSort<T> {
    /** Sort function. */
    public T[] sort(T[] array, Comparator<T> comparator) {
        int size = array.length;

        for (int i = 0; i < size - 1; i++) {
            boolean isSwap = false;

            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) == 1) {
                    swap(array, j);
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }

        return null;
    }

    private void swap(T[] array, int i) {
        T x = array[i + 1];

        array[i + 1] = array[i];
        array[i] = x;
    }
}