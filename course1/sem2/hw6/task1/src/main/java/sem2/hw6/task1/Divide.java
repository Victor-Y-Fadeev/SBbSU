package sem2.hw6.task1;

/** Divide operator class. */
public class Divide extends Operator implements Operand {
    public Divide() {
        operation = '/';
    }

    @Override
    public int calculate() {
        return left.calculate() / right.calculate();
    }
}