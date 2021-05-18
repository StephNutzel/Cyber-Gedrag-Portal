package server.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

public class User extends AbstractModel {

    private String name;
    private String email;
    private TestCaseCatalog testCaseCatalog;

    public User(long id) {
        super(id);
        name = null;
        email = null;
        testCaseCatalog = new TestCaseCatalog();
    }

    public User(long id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
        testCaseCatalog = new TestCaseCatalog();
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
                '}';
    }
}
