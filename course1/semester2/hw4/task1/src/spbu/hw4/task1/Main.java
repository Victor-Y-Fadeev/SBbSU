package spbu.hw4.task1;


public class Main {
    public static void main(String[] args) {
        List<Integer> testList = new UniqueList<>();

        testList.add(5);

        try {
            testList.add(5);
        } catch (Exception e) {
            System.out.println("We caught ElementAlreadyExists() exception ;)");
        }

        try {
            testList.remove(1);
        } catch (Exception e) {
            System.out.println("We caught ElementNotFound() exception ;)");
        }
    }
}