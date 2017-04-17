package spbu.hw6.task1;


public class Multiply extends Operator implements Operand {
    public Multiply() {
        operation = '*';
    }

    @Override
    public int calculate() {
        return left.calculate() * right.calculate();
    }
}