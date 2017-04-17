package spbu.hw6.task1;


public class Plus extends Operator implements Operand {
    public Plus(Operand left, Operand right) {
        operation = '+';
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
}