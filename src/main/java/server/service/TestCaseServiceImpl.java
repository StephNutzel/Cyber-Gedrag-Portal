package server.service;

import server.controller.TestCaseController;
import server.model.TestCase;
import server.repository.TestCaseRepository;
import server.util.HttpConnection;

import java.util.Collection;
import java.util.List;

public class TestCaseServiceImpl implements TestCaseService {

    private TestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        return testCaseRepository.findById(id);
    }

    @Override
    public TestCase insertTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    @Override
    public void updateTestCase(Long id, TestCase testCase) {
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public List<TestCase> getTestCasesByUserId(Long id) {
        return testCaseRepository.findByUserId(id);
    }
}
