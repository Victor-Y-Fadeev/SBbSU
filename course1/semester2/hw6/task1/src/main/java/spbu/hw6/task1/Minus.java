package spbu.hw6.task1;


public class Minus extends Operator implements Operand {
    public Minus() {
        operation = '-';
    }

    @Override
    public int calculate() {
        return left.calculate() - right.calculate();
    }
}