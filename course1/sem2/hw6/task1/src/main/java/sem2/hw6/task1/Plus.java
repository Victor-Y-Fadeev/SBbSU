package sem2.hw6.task1;

/** Plus operator class. */
public class Plus extends Operator implements Operand {
    public Plus() {
        operation = '+';
    }

    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
}