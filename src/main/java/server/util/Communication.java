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
        Response<String> response = HttpConnection.post(path, jsonString, null);
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
        String jsonString = String.format("{\"id\":%d,\"email\":\"%s\",\"password\":\"%s\"}", MainServer.tester.getId(), MainServer.tester.getEmail(), "passwordtemp"/*tester.getPassword()*/);
        String path = HttpConnection.API_URL + "/tester/test_cases";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
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
            testCase.calculateAvgGrade();
        }
        MainServer.tester.setActiveTestCase(testCases.get(0));
    }

    public static void loadTestCasesFilter() {
        TestCaseCatalog testCaseCatalog = new TestCaseCatalog();
        MainServer.tester.setTestCaseCatalog(testCaseCatalog);
        String jsonString = String.format("{\"id\":%d,\"email\":\"%s\",\"password\":\"%s\"}", MainServer.tester.getId(), MainServer.tester.getEmail(), "passwordtemp"/*tester.getPassword()*/);
        String path = HttpConnection.API_URL + "/tester/test_cases";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
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
        MainServer.tester.setActiveTestCase(testCaseCatalog.findAll().get(0));
    }

    public static void loadTestUsers(TestCase testCase) {
        TestUserCatalog testUserCatalog = new TestUserCatalog();
        testCase.setTestUserCatalog(testUserCatalog);
        String jsonString = String.format("" +
                        "{" +
                        "\"id\":\"%d\"," +
                        "\"test_case_id\":\"%d\"" +
                        "}",
                MainServer.tester.getId(),
                testCase.getId());
        String path = HttpConnection.API_URL + "/test_case/test_users";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            return;
        }
        List<TestUser> testUsers = null;

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
            if(testUser.getPasswordTest() != null) {
                testUser.getPasswordTest().calculateGrade();
            }
            loadPopupTest(testUser);
            if(testUser.getPopupTest() != null) {
                testUser.getPopupTest().calculateGrade();
            }
            loadPersonalizeTest(testUser);
            if(testUser.getPersonalizeTest() != null) {
                PersonalizeTest personalizeTest = testUser.getPersonalizeTest();
                loadQuestions(personalizeTest);
                testUser.getPersonalizeTest().calculateGrade();
            }

        }
        testCase.getTestUserCatalog().addList(testUsers);
    }

    public static void loadPersonalizeTest(TestUser testUser) {
        PersonalizeTest personalizeTest = null;
        String jsonString = String.format("" +
                        "{" +
                        "\"id\":\"%d\"" +
                        "}",
                testUser.getId());
        String path = HttpConnection.API_URL + "/test_user/personalise_test";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            return;
        }
        try {
            List<JsonNode> node = Json.parseArray(response.getBody());
            List<PersonalizeTest> personalizeTestList = Json.fromJsonArray(node, PersonalizeTest.class);
            if(personalizeTestList.size() < 1) {
                return;
            }
            if(personalizeTestList.size() > 1) {
                System.out.println("ERROR: Multiple Password tests found for one Test User");
                return;
            }
            personalizeTest = personalizeTestList.get(0);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        testUser.setPersonalizeTest(personalizeTest);
    }

    public static void loadQuestions(PersonalizeTest personalizeTest) {
        List<QuestionTest> questions = null;
        String jsonString = String.format("" +
                        "{" +
                        "\"id\":\"%d\"" +
                        "}",
                personalizeTest.getId());
        String path = HttpConnection.API_URL + "/personalise_test/questions";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            return;
        }
        try {
            List<JsonNode> node = Json.parseArray(response.getBody());
            questions = Json.fromJsonArray(node, QuestionTest.class);
            if(questions.size() < 1) {
                return;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        personalizeTest.setQuestions(questions);

    }

    public static void loadPasswordTest(TestUser testUser) {
        PasswordTest passwordTest = null;
        String jsonString = String.format("" +
                        "{" +
                        "\"id\":\"%d\"" +
                        "}",
                testUser.getId());
        String path = HttpConnection.API_URL + "/test_user/password_test";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
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

    public static void newCompany(String name, int id) {
        String jsonString = String.format("{\"name\":\"%s\", \"id\":\"%s\"}", name, id);
        String path = HttpConnection.API_URL + "/company";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            System.out.println("Server Response: " + response.getStatus());
            return;
        }
        return;
    }
    public static void newDepartment(String name, int id, int companyId) {
        String jsonString = String.format("{\"name\":\"%s\",\"id\":\"%s\",\"companyId\":\"%s\"}", name, id, companyId);
        String path = HttpConnection.API_URL + "/department";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            System.out.println("Server Response: " + response.getStatus());
            return;
        }
        return;
    }
    public static void newTestCase(int id, String time, int departmentId, String name, boolean state, int amount) {
        String jsonString = String.format("{\"id\":\"%s\",\"time\":\"%s\",\"department\":\"%s\",\"name\":\"%s\",\"state\":\"%s\",\"amount\":\"%s\"}",id, time, departmentId, name, state, amount);
        String path = HttpConnection.API_URL + "/new_testcase";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            System.out.println("Server Response: " + response.getStatus());
            return;
        }
        return;
    }

    public static void postPersonalisationQuestion(String question, int testCaseId, int id) {
        String jsonString = String.format("{\"question\":\"%s\",\"testCase\":\"%s\", \"id\":\"%s\"}", question, testCaseId, id);
        String path = HttpConnection.API_URL + "/new_testcase/question";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            System.out.println("Server Response: " + response.getStatus());
            return;
        }
        return;
    }

    public static void loadPopupTest(TestUser testUser) {
        PopupTest popupTest = null;
        String jsonString = String.format("" +
                        "{" +
                        "\"id\":\"%d\"" +
                        "}",
                testUser.getId());
        String path = HttpConnection.API_URL + "/test_user/popup_test";
        Response<String> response = HttpConnection.post(path, jsonString, MainServer.tester.getToken());
        if(response.getStatus() != 200) {
            return;
        }
        try {
            List<JsonNode> node = Json.parseArray(response.getBody());
            List<PopupTest> popupTestList = Json.fromJsonArray(node, PopupTest.class);
            if(popupTestList.size() < 1) {
                return;
            }
            if(popupTestList.size() > 1) {
                System.out.println("ERROR: Multiple Password tests found for one Test User");
                return;
            }
            popupTest = popupTestList.get(0);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        testUser.setPopupTest(popupTest);
    }
}
