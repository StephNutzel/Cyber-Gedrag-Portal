package server;

import org.apache.http.HttpStatus;
import server.model.PasswordTest;
import server.model.TestCase;
import server.model.TestUser;
import server.model.User;

import java.util.HashMap;

public class MainServer {

    public static User user;
    public static TestCase selectedTestCase;

    public static final String API_URL;


    public static void main(String[] args) {
    }

    public static void start(User user) {
        System.out.println(user.toString());

        // -- GET THIS INFO FROM DB -- //

        TestUser testUser1 = new TestUser(1, new PasswordTest(1, 8, 2, 5, 1, 2, 5, 13));
        TestUser testUser2 = new TestUser(2, new PasswordTest(2, 10, 4, 5, 1, 1, 9, 20));
        TestUser testUser3 = new TestUser(3, new PasswordTest(3, 15, 4, 10, 1, 3, 7, 34));
        TestUser testUser4 = new TestUser(4, new PasswordTest(4, 17, 2, 12, 3, 5, 9, 12));
        TestUser testUser5 = new TestUser(5, new PasswordTest(5, 13, 3, 9, 1, 0, 8, 45));
        TestUser testUser6 = new TestUser(6, new PasswordTest(6, 15, 1, 13, 2, 4, 10, 23));

        TestCase testCase = new TestCase(1);
        testCase.addTestUser(testUser1);
        testCase.addTestUser(testUser2);
        testCase.addTestUser(testUser3);
        testCase.addTestUser(testUser4);
        testCase.addTestUser(testUser5);
        testCase.addTestUser(testUser6);

        HashMap<Long, TestCase> testCases = new HashMap<>();
        testCases.put(1L, testCase);

        // -- GET THIS INFO FROM DB -- //

        user.setTestCases(testCases);
        selectedTestCase = user.getTestCases().entrySet().iterator().next().getValue();
    }

    public static User attemptLogin(String email, String password) {
        if(email == null || password == null || email.equals("") || password.equals("")) {
            return null;
        }

        user = new User(1, "Steph", "Steph@email.com");

        return user;
    }

    static {
        API_URL = "https://23.54.23.54/";
    }

}
