package server.service;

import server.model.TestCase;
import server.repository.TestCaseRepository;
import server.util.HttpConnection;
import server.util.Response;

import java.util.List;

public class TestCaseService {

    private TestCaseRepository testCaseRepository;

    public TestCaseService() {
        testCaseRepository = new TestCaseRepository();
    }

    public TestCase getById(Long id) {
        return testCaseRepository.getById(id);
    }

    public void loadListDB(Long userid) {
        Response<String> response = HttpConnection.get("/user/" + userid + "/testcases");
        testCaseRepository.clear();
        List<TestCase> testCaseList = HttpConnection.jsonToObjectArray(response.getResponse().toString(), TestCase.class);
        testCaseRepository.saveTestCaseList(testCaseList);
    }
}
