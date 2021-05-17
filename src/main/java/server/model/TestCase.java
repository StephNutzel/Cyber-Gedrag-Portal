package server.model;

import java.util.HashMap;
import java.util.Objects;

public class TestCase {

    private long id;
    private HashMap<Long, TestUser> testUsers;

    public TestCase(long id) {
        this.id = id;
        this.testUsers = new HashMap<>();
    }

    public TestCase(long id, HashMap<Long, TestUser> testUsers) {
        this.id = id;
        this.testUsers = testUsers;
    }

    public long getId() {
        return id;
    }

    public HashMap<Long, TestUser> getTestUsers() {
        return testUsers;
    }

    public void setTestUsers(HashMap<Long, TestUser> testUsers) {
        this.testUsers = testUsers;
    }

    public void addTestUsers(HashMap<Long, TestUser> testUsers) {
        this.testUsers.putAll(testUsers);
    }

    public void addTestUser(TestUser testUser) {
        this.testUsers.put(testUser.getId(), testUser);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return id == testCase.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
