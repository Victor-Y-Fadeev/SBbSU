package spbu.hw1.task2;

public class Main {
    public static void main(String[] args) {
        List<Integer> testList = new List<>();

        System.out.println("Put some elements...");
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }

        System.out.println("Check it...");
        for (int i = 9; i >= 0; i--) {
            testList.remove(i);
        }

        if (testList.isEmpty()) {
            System.out.println("All tests passed");
        } else {
            System.out.println("All bad!");
        }
    }
}