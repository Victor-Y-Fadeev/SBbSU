package sem2.hw3.task2;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;
import java.io.*;


public class SpiralOutputTest {
    private int[][] matrix;
    private String result;

    @Before
    public void setUpSpiralOutput() {
        matrix = new int[][] { { 0, 1, 2, 3, 4 },
                               { 5, 6, 7, 8, 9 },
                               { 10, 11, 12, 13, 14 },
                               { 15, 16, 17, 18, 19 },
                               { 20, 21, 22, 23, 24} };

        result = "12 11 16 17 18 13 8 7 6 5 10 15 20 21 22 23 24 19 14 9 4 3 2 1 0 ";
    }

    @Test
    public void testFileOutput(){
        SpiralOutput out = new FileOutput();
        String answer = null;

        try {
            out.output(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileReader reader = new FileReader("output.txt")) {
            BufferedReader in = new BufferedReader(reader);
            answer = in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("File output broke", result, answer);
    }

    @Test
    public void testConsoleOutput() {
        SpiralOutput out = new ConsoleOutput();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream our = new PrintStream(baos);
        PrintStream console = System.out;

        System.setOut(our);

        try {
            out.output(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.flush();
        System.setOut(console);

        Assert.assertEquals("Console output broke", result, baos.toString());
    }
}