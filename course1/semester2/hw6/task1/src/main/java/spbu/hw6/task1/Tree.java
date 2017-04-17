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

        root = getRoot(expression);
    }

    public String output() {
        return root.output();
    }

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
                root = new Divide();
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