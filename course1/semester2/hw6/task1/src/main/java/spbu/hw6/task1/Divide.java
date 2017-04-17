package spbu.hw6.task1;


public class Divide extends Operator implements Operand {
    public Divide() {
        operation = '/';
    }

    @Override
    public int calculate() {
        return left.calculate() / right.calculate();
    }
}