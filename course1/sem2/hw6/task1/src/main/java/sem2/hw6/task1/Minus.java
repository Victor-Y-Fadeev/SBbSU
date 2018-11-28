package sem2.hw6.task1;

/** Minus operator class. */
public class Minus extends Operator implements Operand {
    public Minus() {
        operation = '-';
    }

    @Override
    public int calculate() {
        return left.calculate() - right.calculate();
    }
}