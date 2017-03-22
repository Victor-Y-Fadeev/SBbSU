package spbu.hw4.task2;


public class HashTable<DataType extends Comparable, Hasher extends HashFunction> {
    private static final int INITIAL_SIZE = 1024;
    private UniqueList<DataType>[] table;
    private int addedElements;
    private int maxListLenght;
    private int emptyCell;
    private int conflicts;
    private int size;

    public HashTable() {
        Object temp[] = new Object[INITIAL_SIZE];
        table = (UniqueList<DataType>[]) temp;

        addedElements = 0;
        maxListLenght = 0;
        conflicts = 0;
        emptyCell = INITIAL_SIZE;
        size = INITIAL_SIZE;
    }

    public void add(DataType element) {
        if (loadFactor() > 5) {
            resize();
        }

        Hasher hasher = (Hasher) new Object();
        int hash = hasher.getHesh(element.toString()) % size;

        if (table[hash].isExists(element)) {
            return;
        }

        table[hash].add(element);
        addedElements++;

        int listSize = table[hash].getSize();

        if (listSize == 1) {
            emptyCell--;
            return;
        }

        if (listSize == 2) {
            conflicts++;
        }

        if (listSize > maxListLenght) {
            maxListLenght = listSize;
        }
    }

    public void remove(DataType element) {
        Hasher hasher = (Hasher) new Object();
        int hash = hasher.getHesh(element.toString()) % size;

        if (!table[hash].isExists(element)) {
            return;
        }

        table[hash].remove(element);
        addedElements--;

        int listSize = table[hash].getSize();

        if (listSize == 0) {
            emptyCell++;
        }

        if (listSize == 1) {
            conflicts--;
        }
    }

    public boolean isExists(DataType element) {
        Hasher hasher = (Hasher) new Object();
        int hash = hasher.getHesh(element.toString()) % size;

        return table[hash].isExists(element);
    }

    public float loadFactor() {
        return (float)addedElements / size;
    }

    private void resize() {
        UniqueList<DataType>[] oldTable = table;
        Object temp[] = new Object[size * 2];
        int oldSize = size;

        table = (UniqueList<DataType>[]) temp;
        size *= 2;
        conflicts = 0;
        addedElements = 0;
        maxListLenght = 0;
        emptyCell = size;

        for (int i = 0; i < oldSize; i++) {
            int listSize = oldTable[i].getSize();

            for (int j = 0; j < listSize; j++) {
                DataType element = oldTable[i].getFirst();
                add(element);
            }
        }
    }
}