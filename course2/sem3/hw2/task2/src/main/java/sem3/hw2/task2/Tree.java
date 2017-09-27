package sem3.hw2.task2;

public class Tree<T extends Comparable> {
    private Node<T> root;


    public Tree() {
        root = null;
    }

    public void add(T data) {
        if (root == null) {
            root = new Node<T>(data);
            return;
        }

        add(root, data);
    }

    public boolean find(T data) {
        return find(root, data);
    }

    public void remove(T data) {
        if (root == null) {
            return;
        }

        if (root.getData().equals(data)) {
            root = removeNode(root);
            return;
        }

        remove(root, data);
    }

    public boolean isEmpty() {
        return root == null;
    }


    private void add(Node<T> node, T data) {
        if (node.getData().equals(data)) {
            return;
        }

        if (node.getData().compareTo(data) > 0) {
            if (node.getRight() == null) {
                node.setRight(new Node<T>(data));
                return;
            }
            add(node.getRight(), data);
        } else {
            if (node.getLeft() == null) {
                node.setLeft(new Node<T>(data));
                return;
            }
            add(node.getLeft(), data);
        }
    }

    private  boolean find(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (node.getData().equals(data)) {
            return true;
        }

        return find(node.getData().compareTo(data) > 0 ? node.getRight() : node.getLeft(), data);
    }

    private void remove(Node<T> node, T data) {
        if (node.getData().compareTo(data) > 0) {
            if (node.getRight() == null) {
                return;
            }

            if (node.getRight().getData().equals(data)) {
                node.setRight(removeNode(node.getRight()));
                return;
            }

            remove(node.getRight(), data);
        } else {
            if (node.getLeft() == null) {
                return;
            }

            if (node.getLeft().getData().equals(data)) {
                node.setLeft(removeNode(node.getLeft()));
                return;
            }

            remove(node.getLeft(), data);
        }
    }

    private Node<T> removeNode(Node<T> node) {
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
