package spbu.hw7.task1;

/** Main class. */
public class Main {
    /** Main method. */
    public static void main(String[] args) {
        Code code = new Code(ExampleClass.class);

        System.out.println(code.output());
    }

    private class A {

    }
}