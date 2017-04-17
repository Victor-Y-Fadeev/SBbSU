package spbu.hw6.task1;


public abstract class Operator implements Operand {
    protected char operation;
    protected Operand left;
    protected Operand right;


    @Override
    public String output() {
        return "(" + Character.toString(operation) + " " + left.output() + " " + right.output() + ")";
    }

    @Override
    public abstract int calculate();

    public void setLeft(Operand left) {
        this.left = left;
    }

    public void setRight(Operand right) {
        this.right = right;
    }
}