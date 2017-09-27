package sem3.hw2.task2;

import java.util.*;

/** Main class. */
public class Main {
    /** Main method. */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        //iterator.remove();
        System.out.println(iterator.next());
        //System.out.println(iterator.next());
    }
}