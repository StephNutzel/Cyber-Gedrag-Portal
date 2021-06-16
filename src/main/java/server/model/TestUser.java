package server.model;

import java.util.Objects;

public class TestUser extends AbstractModel {

    private PasswordTest passwordTest;
    private PopupTest popupTest;
    private PersonalizeTest personalizeTest;

    public TestUser() {
        super(-1);
        this.passwordTest = new PasswordTest();
        this.popupTest = new PopupTest();
    }

    public TestUser(int id) {
        super(id);
        this.passwordTest = new PasswordTest();
        this.popupTest = new PopupTest();
    }

    public TestUser(int id, PasswordTest passwordTest, PopupTest popupTest) {
        super(id);
        this.passwordTest = passwordTest;
        this.popupTest = popupTest;
    }

    public PasswordTest getPasswordTest() {
        return passwordTest;
    }

    public void setPasswordTest(PasswordTest passwordTest) {
        this.passwordTest = passwordTest;
    }

    public PopupTest getPopupTest() { return popupTest; }

    public void setPopupTest(PopupTest popupTest) { this.popupTest = popupTest; }

    public PersonalizeTest getPersonalizeTest() {
        return personalizeTest;
    }

    public void setPersonalizeTest(PersonalizeTest personalizeTest) {
        this.personalizeTest = personalizeTest;
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
