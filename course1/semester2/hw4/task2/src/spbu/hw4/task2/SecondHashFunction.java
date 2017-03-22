package spbu.hw4.task2;


public class SecondHashFunction implements Hasher {
    @Override
    public int getHash(String element)
    {
        int wordSize = element.length();
        int hash = 0;

        for (int i = 0; i < wordSize; i++)
            hash = hash + element.charAt(i);

        return hash;
    }
}