package spbu.hw6.task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/** Vector implements Set class. */
public class VectorSet<E> implements Set<E> {
    private Vector<E> vector;

    public VectorSet() {
        vector = new Vector<E>();
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return vector.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return vector.iterator();
    }

    @Override
    public Object[] toArray() {
        return vector.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return vector.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }

        vector.add(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return vector.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return vector.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (containsAll(c)) {
            return false;
        }

        c.forEach(value -> add(value));
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return vector.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return vector.removeAll(c);
    }

    @Override
    public void clear() {
        vector.clear();
    }
}