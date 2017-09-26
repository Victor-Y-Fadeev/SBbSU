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


    private void add(Node<T> top, T data) {
        if (top.getData().equals(data)) {
            return;
        }

        if (top.getData().compareTo(data) > 0) {
            if (top.getRight() == null) {
                top.setRight(new Node<T>(data));
                return;
            }
            add(top.getRight(), data);
        } else {
            if (top.getLeft() == null) {
                top.setLeft(new Node<T>(data));
                return;
            }
            add(top.getLeft(), data);
        }
    }

    private  boolean find(Node<T> top, T data) {
        if (top == null) {
            return false;
        }

        if (top.getData().equals(data)) {
            return true;
        }

        return find(top.getData().compareTo(data) > 0 ? top.getRight() : top.getLeft(), data);
    }
}
