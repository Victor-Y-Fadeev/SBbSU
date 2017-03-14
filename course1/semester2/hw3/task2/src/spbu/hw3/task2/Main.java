package spbu.hw3.task2;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < 25; i++) {
            matrix[i / 5][i % 5] = i;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = 5 * i + j;
                System.out.print(5 * i + j);
                System.out.print(" ");
            }
            System.out.println("");
        }

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
}