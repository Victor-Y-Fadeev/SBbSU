package sp;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.*;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        try(FileWriter writer = new FileWriter("firstTestFile.txt")) {
            writer.write("First string with 1024\n");
            writer.write("Second string\n");
            writer.write("Some string with 1024\n");
            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("secondTestFile.txt")) {
            writer.write("First string\n");
            writer.write("This string include 1024\n");
            writer.write("Some string...\n");
            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }

        assertEquals("Error in findQuotes() function!", Arrays.asList("First string with 1024", "Some string with 1024", "This string include 1024"), SecondPartTasks.findQuotes(Arrays.asList("firstTestFile.txt", "secondTestFile.txt") , "1024"));
    }

    @Test
    public void testPiDividedBy4() {
        assertTrue("Error in piDividedBy4() function!", SecondPartTasks.piDividedBy4() * 4 - 3.14 < 0.01);
    }

    @Test
    public void testFindPrinter() {
        Map<String, List<String>> compositions = new HashMap<>();
        compositions.put("First", Arrays.asList("Book one.\nSome text...", "Other book.\nOther text..."));
        compositions.put("Five", Arrays.asList("Five first book.\nFirst path...\nSecond path...", "The book.\nA lot of text...", "Something else.\nText..."));
        compositions.put("Zero", Arrays.asList("No fantasy.\nI don't know..."));

        assertEquals("Error in findPrinter() function!", "Five", SecondPartTasks.findPrinter(compositions));
    }

    @Test
    public void testCalculateGlobalOrder() {
        Map<String, Integer> firstNet = new HashMap<>();
        firstNet.put("Product №64", 125);
        firstNet.put("Product №256", 500);
        firstNet.put("Product №768", 1250);

        Map<String, Integer> secondNet = new HashMap<>();
        secondNet.put("Product №16", 750);
        secondNet.put("Product №2048", 250);

        Map<String, Integer> thirdNet = new HashMap<>();
        thirdNet.put("Product №16", 125);
        thirdNet.put("Product №768", 1750);
        thirdNet.put("Product №2048", 500);
        thirdNet.put("Product №2816", 1000);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Product №16", 875);
        expected.put("Product №64", 125);
        expected.put("Product №256", 500);
        expected.put("Product №768", 3000);
        expected.put("Product №2048", 750);
        expected.put("Product №2816", 1000);

        assertEquals("Error in calculateGlobalOrder() function!", expected, SecondPartTasks.calculateGlobalOrder(Arrays.asList(firstNet, secondNet, thirdNet)));
    }
}