package spbu.hw4.task2;


public class HashTable<DataType extends Comparable> {
    private static final int INITIAL_SIZE = 1024;
    private static final float CRITICAL_LOAD_FACTOR = 5;
    private UniqueList<DataType>[] table;
    private Hasher hasher;
    private int addedElements;
    private int maxListLenght;
    private int emptyCell;
    private int conflicts;
    private int size;

    public HashTable(Hasher hasher) {
        table = (UniqueList<DataType>[]) new UniqueList[INITIAL_SIZE];
        this.hasher = hasher;

        addedElements = 0;
        maxListLenght = 0;
        conflicts = 0;
        emptyCell = INITIAL_SIZE;
        size = INITIAL_SIZE;
    }

    public void add(DataType element) {
        if (loadFactor() > CRITICAL_LOAD_FACTOR) {
            resize();
        }

        int hash = hasher.getHash(element.toString(), size);

        if (table[hash] == null) {
            emptyCell--;
            table[hash] = new UniqueList<>();
            table[hash].add(element);
            addedElements++;
        }

        if (table[hash].isExists(element)) {
            return;
        }

        table[hash].add(element);
        addedElements++;

        int listSize = table[hash].getSize();

        if (listSize == 2) {
            conflicts++;
        }

        if (listSize > maxListLenght) {
            maxListLenght = listSize;
        }
    }

    public void remove(DataType element) {
        int hash = hasher.getHash(element.toString(), size);

        if ((table[hash] == null) || (!table[hash].isExists(element))) {
            return;
        }

        table[hash].remove(element);
        addedElements--;

        int listSize = table[hash].getSize();

        if (listSize == 0) {
            emptyCell++;
            table[hash] = null;
        }

        if (listSize == 1) {
            conflicts--;
        }
    }

    public boolean isExists(DataType element) {
        int hash = hasher.getHash(element.toString(), size);

        return (table[hash] != null) && (table[hash].isExists(element));
    }

    public String getStat() {
        String statistics = "Size: " + size;

        statistics += "\nLoad factor: " + loadFactor();
        statistics += "\nConflicts: " + conflicts;
        statistics += "\nEmpty Cell: " + emptyCell;
        statistics += "\nMax conflict list: " + maxListLenght;
        statistics += "\n";

        return statistics;
    }

    private float loadFactor() {
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