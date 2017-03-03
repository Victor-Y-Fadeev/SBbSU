package spbu.hw1.task1;


public class Main {

    public static void main(String[] args) {

        Stack<Integer> testStack = new Stack<Integer>();
        Integer counter = 0;
        Integer testEmpty = 0;


        System.out.println("Put some elements...");
        for (Integer i = 0; i < 10; i++) {
            testStack.push(i);
        }

        System.out.println("Check it...");
        for (Integer i = 9; i >= 0; i--) {
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
            System.out.println("Stack is empty");
        } else {
            System.out.println("We forgot something!");
        }
    }
}