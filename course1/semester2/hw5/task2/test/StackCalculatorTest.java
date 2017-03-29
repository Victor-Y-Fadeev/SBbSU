import spbu.hw5.task2.StackCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Random;


/** Test class for StackCalculator. */
public class StackCalculatorTest {
    private final int MAX_VALUE = 4096;
    private int firstValue;
    private int secondValue;

    /** Set up values for test. */
    @Before
    public void setUpValues() {
        Random randomizer = new Random();

        firstValue = randomizer.nextInt(MAX_VALUE);
        secondValue = randomizer.nextInt(MAX_VALUE);
    }

    /** Test divide operation. */
    @Test
    public void testPlusOperation() {
        StackCalculator calculator = new StackCalculator();
        String sequence = Integer.toString(firstValue) + "+" + Integer.toString(secondValue) + "=";

        sendSequence(calculator, sequence);
        int result = Integer.parseInt(calculator.getOutput());

        Assert.assertTrue("Plus operation isn't working!", result == (int)(firstValue + secondValue));
    }

    /** Test minus operation. */
    @Test
    public void testMinusOperation() {
        StackCalculator calculator = new StackCalculator();
        String sequence = Integer.toString(firstValue) + "-" + Integer.toString(secondValue) + "=";

        sendSequence(calculator, sequence);
        int result = Integer.parseInt(calculator.getOutput());

        Assert.assertTrue("Minus operation isn't working!", result == (int)(firstValue - secondValue));
    }

    /** Test multiply operation. */
    @Test
    public void testMultiplyOperation() {
        StackCalculator calculator = new StackCalculator();
        String sequence = Integer.toString(firstValue) + "*" + Integer.toString(secondValue) + "=";

        sendSequence(calculator, sequence);
        int result = Integer.parseInt(calculator.getOutput());

        Assert.assertTrue("Multiply operation isn't working!", result == (int)(firstValue * secondValue));
    }

    /** Test divide operation. */
    @Test
    public void testDivideOperation() {
        if (secondValue == 0) {
            return;
        }

        StackCalculator calculator = new StackCalculator();
        String sequence = Integer.toString(firstValue) + "/" + Integer.toString(secondValue) + "=";

        sendSequence(calculator, sequence);
        float floatResult = Float.parseFloat(calculator.getOutput());
        int result = (int) floatResult;

        Assert.assertTrue("Divide operation isn't working!", result == (int)(firstValue / secondValue));
    }

    /** Test output correctness. */
    @Test
    public void testOutputCorrectness() {
        StackCalculator calculator = new StackCalculator();

        sendSequence(calculator, "C");
        Assert.assertEquals("Incorrect operation \"Clean\"", "0", calculator.getOutput());

        sendSequence(calculator, "C,1");
        Assert.assertEquals("Incorrect output \"" + calculator.getOutput() + "\"", "0.1", calculator.getOutput());

        sendSequence(calculator, "C2,+");
        Assert.assertEquals("Incorrect output \"" + calculator.getOutput() + "\"", "2 + ", calculator.getOutput());

        sendSequence(calculator, "C3-,4");
        Assert.assertEquals("Incorrect output \"" + calculator.getOutput() + "\"", "3 - 0.4", calculator.getOutput());

        sendSequence(calculator, "C5-*");
        Assert.assertEquals("Incorrect output \"" + calculator.getOutput() + "\"", "5 * ", calculator.getOutput());

        sendSequence(calculator, "C6=7");
        Assert.assertEquals("Incorrect output \"" + calculator.getOutput() + "\"", "7", calculator.getOutput());

        sendSequence(calculator, "C8=,9");
        Assert.assertEquals("Incorrect output \"" + calculator.getOutput() + "\"", "0.9", calculator.getOutput());

        sendSequence(calculator, "C10=/");
        Assert.assertEquals("Incorrect output \"" + calculator.getOutput() + "\"", "10 / ", calculator.getOutput());
    }

    private void sendSequence(StackCalculator calculator,String sequence) {
        int size = sequence.length();

        for (int i = 0; i < size; i++) {
            calculator.computing(Character.toString(sequence.charAt(i)));
        }
    }
}