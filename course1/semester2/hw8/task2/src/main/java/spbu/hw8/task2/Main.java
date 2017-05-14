package spbu.hw8.task2;

import java.util.Random;

/** Main class. */
public class Main {
    /**
     * Main method.
     * Here we compere parallel & successively sort.
     * */
    public static void main(String[] args) {
        final int ARRAY_SIZE = 4194304;
        Random randomizer = new Random();
        Integer[] array = new Integer[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = randomizer.nextInt();
        }

        Integer[] arrayClone = array.clone();
        SortingAlgorithm<Integer> parallel = new QuickSortParallel<>();
        SortingAlgorithm<Integer> successively = new QuickSortSuccessively<>();

        long temp = System.currentTimeMillis();
        parallel.sort(array);
        long parallelTime = System.currentTimeMillis() - temp;

        temp = System.currentTimeMillis();
        successively.sort(arrayClone);
        long successivelyTime = System.currentTimeMillis() - temp;

        System.out.println("Parallel time: " + parallelTime + " millis");
        System.out.println("Successively time: " + successivelyTime + " millis");
    }
}