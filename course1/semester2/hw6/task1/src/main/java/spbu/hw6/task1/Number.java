package spbu.hw6.task1;


public class Number implements Operand {
    private int number;

    public Number(int number) {
        this.number=number;
    }

    @Override
    public String output() {
        return Integer.toString(number);
    }

    @Override
    public int calculate() {
        return number;
    }
}