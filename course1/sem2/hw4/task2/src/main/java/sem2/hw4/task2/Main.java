package sem2.hw4.task2;

import java.util.Scanner;


public class Main {
    private static final int ADD = 1;
    private static final int REMOVE = 2;
    private static final int FIND = 3;
    private static final int STAT = 4;
    private static final int EXIT = 5;

    public static void main(String[] args) {
        System.out.println("---Select hash function---");
        System.out.println("1) Start = 2139062143; f(s) = 37 * hash + s[i]");
        System.out.println("2) f(s) = s[1] + s[2] + ... + s[n]");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        HashTable<String> hashTable = null;
        if (num == 1) {
            hashTable = new HashTable<>(new FirstHashFunction());
        } else {
            hashTable = new HashTable<>(new SecondHashFunction());
        }

        num = 0;
        while (num != EXIT) {
            menu();

            num = in.nextInt();
            switch (num) {
                case ADD:
                    hashTable.add(getElement());
                    break;
                case REMOVE:
                    hashTable.remove(getElement());
                    break;
                case FIND:
                    if (hashTable.isExists(getElement())) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                case STAT:
                    System.out.println(hashTable.getStat());
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println(ADD + ") Add element");
        System.out.println(REMOVE + ") Remove element");
        System.out.println(FIND + ") Find element");
        System.out.println(STAT + ") Show statistics");
        System.out.println(EXIT + ") Exit");
    }

    private static String getElement() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter string: ");
        String temp = in.nextLine();
        return temp;
    }
}