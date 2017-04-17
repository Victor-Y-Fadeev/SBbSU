package spbu.hw6.task1;


public class Divide extends Operator implements Operand {
    public Divide(Operand left, Operand right) {
        operation = '/';
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() / right.calculate();
    }
}