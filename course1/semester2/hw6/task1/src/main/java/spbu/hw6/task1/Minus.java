package spbu.hw6.task1;


public class Minus extends Operator implements Operand {
    public Minus(Operand left, Operand right) {
        operation = '-';
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() - right.calculate();
    }
}