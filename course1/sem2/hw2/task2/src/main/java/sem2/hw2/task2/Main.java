package sem2.hw2.task2;


public class Main {
    public static void main(String[] args) {
        testSomeList(new SinglyLinkedList<>(), "SinglyLinkedList");
        testSomeList(new DoublyLinkedList<>(), "DoublyLinkedList");
    }

    private static void testSomeList(List<Integer> testList, String listName) {
        System.out.print("Testing ");
        System.out.println(listName);

        System.out.println("Put some elements...");
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }

        System.out.println("Check it...");
        for (int i = 9; i >= 0; i--) {
            testList.remove(i);
        }

        if (testList.isEmpty()) {
            System.out.println("All tests passed\n");
        } else {
            System.out.println("All bad!\n");
        }
    }
}