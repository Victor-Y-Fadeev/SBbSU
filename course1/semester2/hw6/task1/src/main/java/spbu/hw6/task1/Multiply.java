package spbu.hw6.task1;


public class Multiply extends Operator implements Operand {
    public Multiply(Operand left, Operand right) {
        operation = '*';
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() * right.calculate();
    }
}