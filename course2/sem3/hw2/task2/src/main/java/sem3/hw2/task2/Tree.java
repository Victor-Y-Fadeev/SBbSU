package sem3.hw2.task2;

import java.util.Iterator;

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
        } else {
            refresh = node.getLeft() != null ? node.getLeft() : node.getRight();
        }

        if (node.getParent() == null) {
            root = refresh;
        } else {
            if (node.getParent().getLeft().equals(node)) {
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

        public boolean hasNext() {
            return false;
        }

        public T next() {
            return null;
        }

        public void remove() {

        }
    }
}
