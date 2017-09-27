package sem3.hw2.task2;

/** Binary search tree class. */
public class Tree<T extends Comparable> {
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
        if (root == null) {
            return;
        }

        if (root.getValue().equals(value)) {
            root = refreshNode(root);
            return;
        }

        remove(root, value);
    }

    /** Check tree's empty. */
    public boolean isEmpty() {
        return root == null;
    }


    private void add(Node<T> node, T value) {
        if (node.getValue().equals(value)) {
            return;
        }

        if (node.getValue().compareTo(value) > 0) {
            if (node.getRight() == null) {
                node.setRight(new Node<T>(value));
                return;
            }
            add(node.getRight(), value);
        } else {
            if (node.getLeft() == null) {
                node.setLeft(new Node<T>(value));
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

        return find(node.getValue().compareTo(value) > 0 ? node.getRight() : node.getLeft(), value);
    }

    private void remove(Node<T> node, T value) {
        if (node.getValue().compareTo(value) > 0) {
            if (node.getRight() == null) {
                return;
            }

            if (node.getRight().getValue().equals(value)) {
                node.setRight(refreshNode(node.getRight()));
                return;
            }

            remove(node.getRight(), value);
        } else {
            if (node.getLeft() == null) {
                return;
            }

            if (node.getLeft().getValue().equals(value)) {
                node.setLeft(refreshNode(node.getLeft()));
                return;
            }

            remove(node.getLeft(), value);
        }
    }

    private Node<T> refreshNode(Node<T> node) {
        if (node.getRight() != null && node.getLeft() != null) {
            Node<T> temp = node.getRight();

            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }

            temp.setLeft(node.getLeft());
            return node.getRight();
        }

        return node.getLeft() != null ? node.getLeft() : node.getRight();
    }
}
