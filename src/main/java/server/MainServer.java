package server;

import server.model.TestCase;
import server.model.Tester;
import server.util.AVLTree;
import server.util.Communication;

public class MainServer {

    public static Tester tester;

    public static void main(String[] args) {
        System.out.println("AVL TREE START");
        AVLTree<Integer> tree = new AVLTree<>();
        tree.root = tree.insert(tree.root, 4, 4);
        tree.root = tree.insert(tree.root, 5, 5);
        tree.root = tree.insert(tree.root, 6, 6);
        tree.root = tree.insert(tree.root, 7, 7);
        tree.root = tree.insert(tree.root, 8, 8);
        tree.root = tree.insert(tree.root, 9, 9);

        for(Integer ints : tree.getListInRange(tree.root, 5, 7)) {
            System.out.println(ints);
        }
        System.out.println("AVL TREE END");
    }

    public static void start(Tester tester) {
        System.out.println(tester.toString());
    }

    public static Tester attemptLogin(String email, String password) {
        if(email == null || password == null || email.equals("") || password.equals("")) {
            return null;
        }

        tester = Communication.authenticate(email, password);
        if(tester == null) {
            return null;
        }

        Communication.loadTestCases();
        // n.poelenjee@gmail.com
        // $2y$12$kUM4IMH4.K9agpihn/7Wg.zK2u9ww26mDL4NcoQ92IOvzoY6wvy/K

        return tester;
    }

}
