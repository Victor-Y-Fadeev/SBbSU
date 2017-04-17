package spbu.hw6.task1;


public class Plus extends Operator implements Operand {
    public Plus() {
        operation = '+';
    }

    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
}