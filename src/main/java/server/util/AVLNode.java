package server.util;

public class AVLNode<T> {
    public int key, height;
    public T value;
    public AVLNode<T> left, right;

    public AVLNode(int key, T value) {
        this.key = key;
        this.value = value;
        height = 1;
    }

    public boolean hasLeft() {
        if (left == null) {
            return false;
        }
        return true;
    }

    public boolean hasRight() {
        if (right == null) {
            return false;
        }
        return true;
    }
}
