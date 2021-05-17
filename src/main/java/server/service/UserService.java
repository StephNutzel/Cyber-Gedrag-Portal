package server.service;

import server.model.TestUser;
import server.model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserService implements Service<Long, User>{

    private static HashMap<Long, User> users = new HashMap<>();

    @Override
    public void create(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User read(Long aLong) {
        return null;
    }

    @Override
    public void update(Long id) {
        User testUser = users.get(id);
        users.put(testUser.getId(), testUser);
    }

    @Override
    public void delete(Long id) {
        users.remove(id);
    }

    @Override
    public Collection<User> getCollection() {
        return users.values();
    }
}
