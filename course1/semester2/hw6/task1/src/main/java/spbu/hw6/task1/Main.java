package spbu.hw6.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree("input.txt");

        System.out.print(tree.output());
        System.out.print(" = ");
        System.out.println(tree.calculate());
    }
}