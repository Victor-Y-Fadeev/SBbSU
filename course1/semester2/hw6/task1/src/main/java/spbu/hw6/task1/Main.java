package spbu.hw6.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Maven!");

        try(FileReader reader = new FileReader("input.txt")) {
            BufferedReader in = new BufferedReader(reader);
            //answer = in.readLine();
            System.out.println(in.readLine());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}