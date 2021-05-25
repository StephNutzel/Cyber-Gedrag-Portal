package server.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.Objects;

public class TestCase extends AbstractModel {

    private Date date;
    private TestUserCatalog testUserCatalog;

    public TestCase(Integer id) {
        super(id);
        date = new Date(0L);
    }

    public TestCase(Integer id, Date date) {
        super(id);
        this.date = date;
        testUserCatalog = new TestUserCatalog();
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TestUserCatalog getTestUserCatalog() {
        return testUserCatalog;
    }

    public void setTestUserCatalog(TestUserCatalog testUserCatalog) {
        this.testUserCatalog = testUserCatalog;
    }

    public void addTestUser(TestUser testUser) {
        testUserCatalog.add(testUser);
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
