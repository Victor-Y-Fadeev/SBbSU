package spbu.hw5.task1;


/**
 * Class for counts expressions.
 * This class is the logic of program.
 * */
public class Calculator {
    private final int MAX_VALUE = 9;
    private final int MIN_VALUE = 0;

    /** Return max allowable value. */
    public int getMaxValue() {
        return MAX_VALUE;
    }

    /** Return min allowable value. */
    public int getMinValue() {
        return MIN_VALUE;
    }

    /** Count expression.
     *  It counts expression consists of 2 argument.
     *  For example, "7 - 5 =".
     *  List of allowable operations: "+", "-", "*", "/".
     *
     * @param operation     Operation symbol
     * @param firstValue    First number
     * @param secondValue   Second number
     * @return Calculating result
     * */
    public int count(String operation, int firstValue, int secondValue) {
        int result = 0;

        switch (operation) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                result = firstValue / secondValue;
                break;
        }

        return result;
    }
}