package server.controller;

import org.apache.http.HttpStatus;
import org.junit.Test;
import server.model.TestCase;
import server.model.TestUser;
import server.service.TestCaseService;
import server.service.TestUserService;
import server.util.HttpConnection;
import server.util.Response;

public class TestCaseController {

    private TestCaseService testCaseService;

    public Response<TestCase> getTestCase(Long id) {
        String path = "/testcase/" + id;
        return new Response<>(testCaseService.getTestCaseById(id), HttpStatus.SC_OK);
    }

    public Response<TestCase> saveTestCase(TestCase testCase) {
        String path = "/testcase/" + testCase.getId();
        return new Response<>(testCaseService.insertTestCase(testCase), HttpStatus.SC_CREATED);
    }

    public Response<TestCase> updateTestCase(Long id, TestCase testCase) {
        String path = "/testcase/" + id;
        testCaseService.updateTestCase(id, testCase);
        return new Response<>(testCaseService.getTestCaseById(id), HttpStatus.SC_OK);
    }

    public Response<?> deleteTestCase(Long id) {
        String path = "/testcase/" + id;
        testCaseService.deleteTestCase(id);
        return new Response<>(HttpStatus.SC_NO_CONTENT);
    }

    public Response<?> getTestCases() {
        String path = "/testcases";
        return new Response<>(testCaseService.getTestCases(), HttpStatus.SC_OK);
    }

    public Response<?> getTestCasesByUserId(Long id) {
        String path = "/user/" + id + "/testcases";
        return new Response<>(testCaseService.getTestCasesByUserId(id), HttpStatus.SC_OK);
    }
}
