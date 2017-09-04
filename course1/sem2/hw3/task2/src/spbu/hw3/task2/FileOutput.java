package spbu.hw3.task2;

import java.io.*;


public class FileOutput extends SpiralConverter {
    @Override
    public void output(int[][] matrix){
        int[] sequence = converter(matrix);

        try(FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < sequence.length; i++) {
                writer.write(((Integer)sequence[i]).toString());
                writer.write(" ");
            }

            writer.flush();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}