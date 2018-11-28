package sem2.hw3.task2;

import java.io.IOException;


public abstract class SpiralConverter implements SpiralOutput {
    @Override
    abstract public void output(int[][] matrix) throws IOException;

    protected int[] converter(int[][] matrix) {
        int size = matrix.length;
        int[] answer = new int[size * size];

        int left = (size - 1) / 2;
        int right = left;

        int i = left;
        int j = left;

        for (int k = 0; k < size * size; k++) {
            answer[k] = matrix[i][j];
            if ((j == left) && (i == left)) {
                right++;
                left--;
                j--;
                continue;
            }
            if ((j == left) && (i < right)) {
                i++;
                continue;
            }
            if ((j < right) && (i == right)) {
                j++;
                continue;
            }
            if ((j == right) && (i > left)) {
                i--;
                continue;
            }
            if ((j > left) && (i == left)) {
                j--;
                continue;
            }
        }

        return answer;
    }
}