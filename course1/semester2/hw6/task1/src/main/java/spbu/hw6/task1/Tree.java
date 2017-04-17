package spbu.hw6.task1;

import java.io.*;


public class Tree {
    private Operator root;

    public Tree(String input) {
        String expression = null;

        try(FileReader reader = new FileReader(input)) {
            BufferedReader in = new BufferedReader(reader);
            expression = in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        root = getOperator(expression);
    }

    public String output() {
        return root.output();
    }

    public int calculate() {
        return root.calculate();
    }

    private Operator getOperator(String expression) {
        return null;
    }
}