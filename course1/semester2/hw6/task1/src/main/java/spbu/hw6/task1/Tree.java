package spbu.hw6.task1;

import java.io.*;

/** Parse tree class. */
public class Tree {
    private Operator root;

    /**
     * Load tree from file.
     *
     * @param input File name
     * */
    public Tree(String input) {
        String expression = null;

        try(FileReader reader = new FileReader(input)) {
            BufferedReader in = new BufferedReader(reader);
            expression = in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        root = getRoot(expression);
    }

    /** Get arithmetic expression. */
    public String output() {
        return root.output();
    }

    /** Get result of calculating. */
    public int calculate() {
        return root.calculate();
    }


    private Operator getRoot(String expression) {
        int[] i = new int[1];
        i[0] = 0;

        return getOperator(expression, i);
    }

    private Operator getOperator(String str, int[] i) {
        Operator operator = null;
        i[0]++;

        switch (str.charAt(i[0])) {
            case '+':
                operator = new Plus();
                break;
            case '-':
                operator = new Minus();
                break;
            case '*':
                operator = new Multiply();
                break;
            case '/':
                operator = new Divide();
                break;
        }
        i[0] += 2;

        if (str.charAt(i[0]) == '(') {
            operator.setLeft(getOperator(str, i));
        } else {
            operator.setLeft(new Number(getNumber(str, i)));
        }

        i[0]++;
        if (str.charAt(i[0]) == '(') {
            operator.setRight(getOperator(str, i));
        } else {
            operator.setRight(new Number(getNumber(str, i)));
        }

        i[0]++;

        return operator;
    }

    private int getNumber(String str, int[] i) {
        int answer = 0;

        while ((str.charAt(i[0]) > '0') && (str.charAt(i[0]) < '9')) {
            answer *= 10;
            answer += str.charAt(i[0]) - '0';
            i[0]++;
        }

        return answer;
    }
}