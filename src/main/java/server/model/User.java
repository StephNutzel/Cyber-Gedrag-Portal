package server.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

public class User {

    private long id;
    private String name;
    private String email;
    private HashMap<Long, TestCase> testCases;

    public User(long id) {
        this.id = id;
    }

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<Long, TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(HashMap<Long, TestCase> testCases) {
        this.testCases = testCases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", testCases=" + testCases +
                '}';
    }
}
