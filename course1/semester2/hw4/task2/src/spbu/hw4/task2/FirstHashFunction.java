package spbu.hw4.task2;


public class FirstHashFunction implements Hasher {
    @Override
    public int getHash(String element)
    {
        int wordSize = element.length();

        int hash = 2139062143;
        for (int i = 0; i < wordSize; i++)
            hash = 37 * hash + (int)element.charAt(i);

        return hash;
    }
}