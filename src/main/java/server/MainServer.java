package server;

import server.model.Tester;
import server.util.Communication;

public class MainServer {

    public static Tester tester;


    public static void main(String[] args) {
    }

    public static void start(Tester tester) {
        System.out.println(tester.toString());

    }

    public static Tester attemptLogin(String email, String password) {
        if(email == null || password == null || email.equals("") || password.equals("")) {
            return null;
        }

        tester = Communication.authenticate(email, password);
        Communication.loadTestCases(tester);
        // n.poelenjee@gmail.com
        // $2y$12$kUM4IMH4.K9agpihn/7Wg.zK2u9ww26mDL4NcoQ92IOvzoY6wvy/K

        return tester;
    }

}
