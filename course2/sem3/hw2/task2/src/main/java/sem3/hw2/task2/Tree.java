package sem3.hw2.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Binary search tree class. */
public class Tree<T extends Comparable> implements Iterable<T> {
    private Node<T> root;


    /** Create tree. */
    public Tree() {
        root = null;
    }

    /** Add value to tree. */
    public void add(T value) {
        if (root == null) {
            root = new Node<T>(value);
            return;
        }

        add(root, value);
    }

    /** Check value contain. */
    public boolean find(T value) {
        return find(root, value);
    }

    /** Remove value from tree. */
    public void remove(T value) {
        remove(root, value);
    }

    /** Check tree's empty. */
    public boolean isEmpty() {
        return root == null;
    }

    /** Get iterator for tree. */
    public Iterator<T> iterator() {
        return new TreeIterator();
    }


    private void add(Node<T> node, T value) {
        if (node.getValue().equals(value)) {
            return;
        }

        if (value.compareTo(node.getValue()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new Node<T>(value));
                node.getRight().setParent(node);
                return;
            }
            add(node.getRight(), value);
        } else {
            if (node.getLeft() == null) {
                node.setLeft(new Node<T>(value));
                node.getLeft().setParent(node);
                return;
            }
            add(node.getLeft(), value);
        }
    }

    private  boolean find(Node<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (node.getValue().equals(value)) {
            return true;
        }

        return find(value.compareTo(node.getValue()) > 0 ? node.getRight() : node.getLeft(), value);
    }

    private void remove(Node<T> node, T value) {
        if (node == null) {
            return;
        }

        if (node.getValue().equals(value)) {
            refreshNode(node);
            return;
        }

        remove(value.compareTo(node.getValue()) > 0 ? node.getRight() : node.getLeft(), value);
    }

    private void refreshNode(Node<T> node) {
        Node<T> refresh = null;

        if (node.getRight() != null && node.getLeft() != null) {
            refresh = node.getLeft();

            Node<T> temp = refresh;
            while (temp.getRight() != null) {
                temp = temp.getRight();
            }
            temp.setRight(node.getRight());
            node.getRight().setParent(temp);
        } else {
            refresh = node.getLeft() != null ? node.getLeft() : node.getRight();
        }

        if (node.getParent() == null) {
            root = refresh;
        } else {
            if (node.getParent().getLeft() != null && node.getParent().getLeft().equals(node)) {
                node.getParent().setLeft(refresh);
            } else {
                node.getParent().setRight(refresh);
            }
        }

        if (refresh != null) {
            refresh.setParent(node.getParent());
        }
    }


    private class TreeIterator implements Iterator<T> {
        private Node<T> current;
        private Node<T> next;


        public TreeIterator() {
            current = null;
            next = root;

            while (next != null && next.getLeft() != null) {
                next = next.getLeft();
            }
        }

        public boolean hasNext() {
            return next != null;
        }

        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            current = next;
            next = getNext();

            return current.getValue();
        }

        public void remove() {
            if (current == null) {
                throw new IllegalStateException();
            }

            refreshNode(current);
        }


        private Node<T> getNext() {
            if (next.getRight() != null) {
                Node<T> temp = next.getRight();

                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }

                return temp;
            }

            Node<T> temp = next;
            while (temp.getParent() != null && temp.getParent().getRight() != null && temp.getParent().getRight().equals(temp)) {
                temp = temp.getParent();
            }

            return temp.getParent();
        }
    }
}
