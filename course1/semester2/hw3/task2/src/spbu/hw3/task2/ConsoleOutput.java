package spbu.hw3.task2;


public class ConsoleOutput extends SpiralConverter {
    @Override
    public void output(int[][] matrix) {
        int[] sequence = converter(matrix);

        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i]);
            System.out.print(" ");
        }

        System.out.println("");
    }
}