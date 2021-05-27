package server.model;

import java.util.Objects;

public class TestUser extends AbstractModel {

    private PasswordTest passwordTest;

    public TestUser() {
        super(-1);
        this.passwordTest = new PasswordTest();
    }

    public TestUser(int id) {
        super(id);
        this.passwordTest = new PasswordTest();
    }

    public TestUser(int id, PasswordTest passwordTest) {
        super(id);
        this.passwordTest = passwordTest;
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

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                '}';
    }
}
