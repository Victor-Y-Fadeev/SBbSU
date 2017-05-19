package spbu.test2.task1;

import java.util.Random;


/** Logic of pair game. */
public class Pair {
    private int[][] matrix;
    private String firstButton;
    private String secondButton;

    /** Create pair game. */
    public Pair(int N) {
        Random randomizer = new Random();
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = randomizer.nextInt(N * N / 2);

                    int a = randomizer.nextInt(N);
                    int b = randomizer.nextInt(N);
                    while (matrix[a][b] != -1) {
                        a = randomizer.nextInt(N);
                        b = randomizer.nextInt(N);
                    }
                    matrix[a][b] = matrix[i][j];
                }
            }
        }
    }

    /** Make a game move. */
    public void checkButtons(int firstColumn, int firstRow, int secondColumn, int secondRow) {
        firstButton = Integer.toString(matrix[firstColumn][firstRow]);
        secondButton = Integer.toString(matrix[secondColumn][secondRow]);
    }

    /** Get first button text. */
    public String getFirstButton() {
        return firstButton;
    }

    /** Get second button text. */
    public String getSecondButton() {
        return secondButton;
    }

    /** Check equals of button numbers. */
    public boolean checkEquals() {
        return firstButton.equals(secondButton);
    }
}