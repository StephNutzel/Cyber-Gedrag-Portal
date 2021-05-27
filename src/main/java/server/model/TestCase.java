package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.HashMap;
import java.util.Objects;

public class TestCase extends AbstractModel {

    @JsonProperty("created_on")
    private Date date;
    private TestUserCatalog testUserCatalog;

    public TestCase() {
        super(-1);
        date = new Date(0L);
        testUserCatalog = new TestUserCatalog();
    }

    public TestCase(int id) {
        super(id);
        date = new Date(0L);
        testUserCatalog = new TestUserCatalog();
    }

    public TestCase(int id, Date date) {
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

    @Override
    public String toString() {
        return "TestCase{" +
                "date=" + date +
                ", id=" + id +
                '}';
    }
}
