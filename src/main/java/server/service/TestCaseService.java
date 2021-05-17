package server.service;

import com.thaiopensource.xml.em.EntityManager;
import server.controller.TestCaseController;
import server.model.TestCase;
import server.repository.TestCaseRepository;
import server.util.HttpConnection;
import server.util.Response;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface TestCaseService {

    TestCase getTestCaseById(Long id);
    TestCase insertTestCase(TestCase testCase);
    void updateTestCase(Long id, TestCase testCase);
    void deleteTestCase(Long id);
    List<TestCase> getTestCases();
    List<TestCase> getTestCasesByUserId(Long id);

}
