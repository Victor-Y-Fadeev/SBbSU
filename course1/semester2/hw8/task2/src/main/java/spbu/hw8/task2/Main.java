package spbu.hw8.task2;

import java.util.Random;

/** Main class. */
public class Main {
    /**
     * Main method.
     * Here we compere parallel & successively sort.
     * */
    public static void main(String[] args) {
        final int ARRAY_SIZE = 1048576;
        final int REPEATS = 16;

        long successivelyTime = 0;
        long parallelTime = 0;

        for (int i = 0; i < REPEATS; i++) {
            Integer[] array = arrayGenerator(ARRAY_SIZE);

            successivelyTime += countSuccessively(array.clone());
            parallelTime += countParallel(array);
        }

        successivelyTime /= REPEATS;
        parallelTime /= REPEATS;

        System.out.println("Parallel time: " + parallelTime + " millis");
        System.out.println("Successively time: " + successivelyTime + " millis");
    }

    private static long countSuccessively(Integer[] array) {
        SortingAlgorithm<Integer> successively = new QuickSortSuccessively<>();

        long time = System.currentTimeMillis();
        successively.sort(array);

        return System.currentTimeMillis() - time;
    }

    private static long countParallel(Integer[] array) {
        SortingAlgorithm<Integer> parallel = new QuickSortParallel<>();

        long time = System.currentTimeMillis();
        parallel.sort(array);

        return System.currentTimeMillis() - time;
    }

    private static Integer[] arrayGenerator(int arraySize) {
        Random randomizer = new Random();
        Integer[] array = new Integer[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = randomizer.nextInt();
        }

        return array;
    }
}