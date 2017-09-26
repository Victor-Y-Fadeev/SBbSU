package sem3.hw2.task2;

public class Node<T> {
    private final T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void setRight(Node<T> node) {
        right = node;
    }

    public void setLeft(Node<T> node) {
        left = node;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }
}
