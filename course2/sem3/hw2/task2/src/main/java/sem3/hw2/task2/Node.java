package sem3.hw2.task2;

/** Node of tree. */
public class Node<T> {
    private final T value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    /** Create node. */
    public Node(T value) {
        this.value = value;
        parent = null;
        left = null;
        right = null;
    }

    /** Set node's parent. */
    public void setParent(Node<T> node) {
        parent = node;
    }

    /** Set right node. */
    public void setRight(Node<T> node) {
        right = node;
    }

    /** Set left node. */
    public void setLeft(Node<T> node) {
        left = node;
    }

    /** Get node's value. */
    public T getValue() {
        return value;
    }

    /** Get node's parent. */
    public Node<T> getParent() {
        return parent;
    }

    /** Get left node. */
    public Node<T> getLeft() {
        return left;
    }

    /** Get right node. */
    public Node<T> getRight() {
        return right;
    }
}
