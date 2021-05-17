package server.service;

import server.model.TestUser;

import java.util.Collection;
import java.util.HashMap;

public class TestUserService implements Service<Long, TestUser> {

    private static HashMap<Long, TestUser> testUsers = new HashMap<>();

    @Override
    public void create(TestUser testUser) {
        testUsers.put(testUser.getId(), testUser);
    }

    @Override
    public TestUser read(Long id) {
        return testUsers.get(id);
    }

    @Override
    public void update(Long id) {
        TestUser testUser = testUsers.get(id);
        testUsers.put(testUser.getId(), testUser);
    }

    @Override
    public void delete(Long id) {
        testUsers.remove(id);
    }

    @Override
    public Collection<TestUser> getCollection() {
        return testUsers.values();
    }
}
