package spbu.hw2.task1;

import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        testSomeStack(new StackList<>(), "StackList");
        testSomeStack(new StackVector<>(), "StackVector");

        StackCalculator calculator = new StackCalculator();
        System.out.print("5 * (7 + 8) + 25 = ");
        System.out.println(calculator.computing("5 * (7 + 8) + 25"));
    }

    private static void testSomeStack(Stack<Integer> testStack, String stackName) {
        Integer counter = 0;
        Integer testEmpty = 0;

        System.out.print("Testing ");
        System.out.println(stackName);

        System.out.println("Put some elements...");
        for (int i = 0; i < 10; i++) {
            testStack.push(i);
        }

        System.out.println("Check it...");
        for (int i = 9; i >= 0; i--) {
            if (i == testStack.pop()) {
                counter++;
            }
        }

        if (counter == 10) {
            System.out.println("All tests passed");
        } else {
            System.out.println("All bad!");
        }

        testEmpty = testStack.pop();
        if (testEmpty == null) {
            System.out.println("Stack is empty\n");
        } else {
            System.out.println("We forgot something!\n");
        }
    }
}
