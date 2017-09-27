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
        left = null;
        right = null;
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

    /** Get left node. */
    public Node<T> getLeft() {
        return left;
    }

    /** Get right node. */
    public Node<T> getRight() {
        return right;
    }
}
