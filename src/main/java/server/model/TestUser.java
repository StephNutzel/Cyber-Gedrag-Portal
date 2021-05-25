package server.model;

import java.util.Objects;

public class TestUser extends AbstractModel {

    private PasswordTest passwordTest;

    public TestUser(Integer id) {
        super(id);
    }

    public TestUser(Integer id, PasswordTest passwordTest) {
        super(id);
        this.passwordTest = passwordTest;
    }

    public long getId() {
        return id;
    }

    public PasswordTest getPasswordTest() {
        return passwordTest;
    }

    public void setPasswordTest(PasswordTest passwordTest) {
        this.passwordTest = passwordTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestUser testUser = (TestUser) o;
        return id == testUser.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
