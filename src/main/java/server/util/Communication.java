package server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import server.MainServer;
import server.model.*;

import java.util.List;
import java.util.Map;

public class Communication {

    public static Tester authenticate(String email, String password) {
        String jsonString = String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password);
        String path = HttpConnection.API_URL + "/tester/auth";
        Response<String> response = HttpConnection.post(path, jsonString);
        if(response.getStatus() != 200) {
            return null;
        }

        JsonNode node = null;
        try {
            node = Json.parse(response.getBody());
            Tester tester = Json.fromJson(node, Tester.class);
            return tester;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadTestCases() {
        TestCaseCatalog testCaseCatalog = new TestCaseCatalog();
        MainServer.tester.setTestCaseCatalog(testCaseCatalog);
        String jsonString = String.format("{\"email\":\"%s\",\"password\":\"%s\"}", MainServer.tester.getEmail(), "passwordtemp"/*tester.getPassword()*/);
        String path = HttpConnection.API_URL + "/tester/test_cases";
        Response<String> response = HttpConnection.post(path, jsonString);
        if(response.getStatus() != 200) {
            return;
        }

        List<TestCase> testCases = null;
        try {
            List<JsonNode> nodeList = Json.parseArray(response.getBody());
            testCases = Json.fromJsonArray(nodeList, TestCase.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        if(testCases == null) return;

        for(TestCase testCase : testCases) {
            loadTestUsers(testCase);
            testCaseCatalog.add(testCase);
        }
        MainServer.tester.setTestCaseCatalog(testCaseCatalog);
    }

    public static void loadTestUsers(TestCase testCase) {
        TestUserCatalog testUserCatalog = new TestUserCatalog();
        testCase.setTestUserCatalog(testUserCatalog);
        String jsonString = String.format("{\"email\":\"%s\",\"password\":\"%s\",\"test_case_id\":%d}", MainServer.tester.getEmail(), "passwordtemp"/*tester.getPassword()*/, testCase.getId());
        String path = HttpConnection.API_URL + "/test_case/test_users";
        Response<String> response = HttpConnection.post(path, jsonString);
        if(response.getStatus() != 200) {
            return;
        }
        List<TestUser> testUsers = null;
        System.out.println(response.getBody());

        try {
            List<JsonNode> nodeList = Json.parseArray(response.getBody());
            testUsers = Json.fromJsonArray(nodeList, TestUser.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        if(testUsers == null) return;

        for(TestUser testUser : testUsers) {
            loadPasswordTest(testUser);
            if(testUser.getPasswordTest() != null)
                testUser.getPasswordTest().calculateGrade();
            System.out.println(testUser.getPasswordTest());
        }

        testCase.getTestUserCatalog().addList(testUsers);
        System.out.println(testCase.getTestUserCatalog());
    }

    public static void loadPasswordTest(TestUser testUser) {
        PasswordTest passwordTest = null;
        testUser.setPasswordTest(passwordTest);
        String jsonString = String.format("{\"email\":\"%s\",\"password\":\"%s\",\"id\":%d}", MainServer.tester.getEmail(), "passwordtemp"/*tester.getPassword()*/, testUser.getId());
        String path = HttpConnection.API_URL + "/test_user/password_test";
        Response<String> response = HttpConnection.post(path, jsonString);
        if(response.getStatus() != 200) {
            return;
        }
        try {
            List<JsonNode> node = Json.parseArray(response.getBody());
            List<PasswordTest> passwordTestList = Json.fromJsonArray(node, PasswordTest.class);
            if(passwordTestList.size() < 1) {
                return;
            }
            if(passwordTestList.size() > 1) {
                System.out.println("ERROR: Multiple Password tests found for one Test User");
                return;
            }
            passwordTest = passwordTestList.get(0);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        testUser.setPasswordTest(passwordTest);
    }

}
