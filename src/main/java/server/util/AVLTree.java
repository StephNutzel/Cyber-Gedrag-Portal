package server.util;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T> {

    public AVLNode<T> root;

    public AVLTree() {
        this.root = null;
    }

    // A utility function to get the height of the tree
    public int height(AVLNode<T> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    public AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    public int getBalance(AVLNode N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    public AVLNode<T> insert(AVLNode<T> node, int key, T value) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new AVLNode<T>(key, value));

        if (key < node.key)
            node.left = insert(node.left, key, value);
        else if (key > node.key)
            node.right = insert(node.right, key, value);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    public void printPreOrder(AVLNode<T> node) {
        if (node != null) {
            System.out.print(node.key + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    // A utility function to print inorder traversal
    // of the tree.
    // The function also prints height of every node
    public void printInOrder(AVLNode<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }

    // A utility function to print inorder traversal
    // of the tree.
    // The function also prints height of every node
    public void printPostOrder(AVLNode<T> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public List<T> getListInOrder(AVLNode<T> node) {
        List<T> list = new ArrayList<>();
        return getListInOrderRecursive(node, list);
    }

    public List<T> getListInOrderRecursive(AVLNode<T> node, List<T> list) {
        if (node != null) {
            getListInOrderRecursive(node.left, list);
            list.add(node.value);
            getListInOrderRecursive(node.right, list);
        }
        return list;
    }

    public List<T> getListInRange(AVLNode<T> node, int min, int max) {
        List<T> list = new ArrayList<>();
        return getListInRangeRecursive(node, min, max, list);
    }

    public List<T> getListInRangeRecursive(AVLNode<T> node, int min, int max, List<T> list) {
        if (node != null) {
            getListInRangeRecursive(node.left, min, max, list);
            if(node.key > max) {
                return list;
            }
            if(node.key >= min) {
                list.add(node.value);
            }
            getListInRangeRecursive(node.right, min, max, list);
        }
        return list;
    }
}

