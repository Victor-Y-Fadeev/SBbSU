import spbu.hw5.task1.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Random;


/** Test class for Calculator. */
public class CalculatorTest {
    private int firstValue;
    private int secondValue;

    /** Set up values for test. */
    @Before
    public void setUpValues() {
        Random randomizer = new Random();

        firstValue = randomizer.nextInt();
        secondValue = randomizer.nextInt();
    }

    /** Test divide operation. */
    @Test
    public void testPlusOperation() {
        Calculator calculator = new Calculator();

        int result = calculator.count("+", firstValue, secondValue);

        Assert.assertTrue("Plus operation isn't working!", result == (int)(firstValue + secondValue));
    }

    /** Test minus operation. */
    @Test
    public void testMinusOperation() {
        Calculator calculator = new Calculator();

        int result = calculator.count("-", firstValue, secondValue);

        Assert.assertTrue("Minus operation isn't working!", result == (int)(firstValue - secondValue));
    }

    /** Test multiply operation. */
    @Test
    public void testMultiplyOperation() {
        Calculator calculator = new Calculator();

        int result = calculator.count("*", firstValue, secondValue);

        Assert.assertTrue("Multiply operation isn't working!", result == (int)(firstValue * secondValue));
    }

    /** Test divide operation. */
    @Test
    public void testDivideOperation() {
        if (secondValue == 0) {
            return;
        }

        Calculator calculator = new Calculator();

        int result = calculator.count("/", firstValue, secondValue);

        Assert.assertTrue("Divide operation isn't working!", result == (int)(firstValue / secondValue));
    }
}