package server.repository;

import server.model.TestCase;

import java.util.HashMap;
import java.util.List;

public interface TestCaseRepository {

    TestCase save(TestCase testCase);
    void deleteById(Long id);
    TestCase findById(Long id);
    List<TestCase> findByUserId(Long id);
    List<TestCase> findAll();

}
