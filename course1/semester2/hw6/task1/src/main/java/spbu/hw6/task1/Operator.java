package spbu.hw6.task1;

/**
 * Class for operators.
 * This abstract class implements
 * basic method of operators.
 * */
public abstract class Operator implements Operand {
    /** Operation symbol. */
    protected char operation;
    /** Left operand. */
    protected Operand left;
    /** Right operand. */
    protected Operand right;


    @Override
    public String output() {
        return "(" + Character.toString(operation) + " " + left.output() + " " + right.output() + ")";
    }

    @Override
    public abstract int calculate();

    /** Set left operand. */
    public void setLeft(Operand left) {
        this.left = left;
    }

    /** Set right operand. */
    public void setRight(Operand right) {
        this.right = right;
    }
}