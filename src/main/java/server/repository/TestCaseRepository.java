package server.repository;

import server.model.TestCase;
import server.util.HttpConnection;

import java.util.HashMap;
import java.util.List;

public class TestCaseRepository {

    private HashMap<Long, TestCase> testCases;

    public TestCaseRepository() {
        this.testCases = new HashMap<>();
    }

    public TestCase getById(Long id) {
        return testCases.get(id);
    }

    public void save(TestCase testCase) {
        this.testCases.put(testCase.getId(), testCase);
    }

    public void delete(TestCase testCase) {
        this.testCases.remove(testCase.getId());
    }

    public void deleteById(Long id) {
        this.testCases.remove(id);
    }

    public List<TestCase> getTestCaseList() {
        return (List<TestCase>)testCases.values();
    }

    public void saveTestCaseList(List<TestCase> testCaseList) {
        for(TestCase t : testCaseList) {
            testCases.put(t.getId(), t);
        }
    }

    public void clear() {
        testCases.clear();
    }

    public HashMap<Long, TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(HashMap<Long, TestCase> testCases) {
        this.testCases = testCases;
    }
}
