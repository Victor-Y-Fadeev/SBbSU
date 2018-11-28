package sem2.hw3.task2;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] matrix = inputMatrix();

        System.out.print("\nSelect output type (Console/File): ");
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();

        if ((temp.compareTo("File") == 0) || (temp.compareTo("file") == 0)
                || (temp.compareTo("F") == 0) ||(temp.compareTo("f") == 0)) {
            SpiralOutput out = new FileOutput();
            out.output(matrix);
        } else {
            SpiralOutput out = new ConsoleOutput();
            out.output(matrix);
        }
    }

    private static int[][] inputMatrix() {
        System.out.print("Enter matrix size: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] answer = new int[n][n];

        System.out.print("Enter matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = in.nextInt();
            }
        }

        return answer;
    }
}