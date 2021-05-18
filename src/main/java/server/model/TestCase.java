package server.model;

import java.util.HashMap;
import java.util.Objects;

public class TestCase extends AbstractModel {

    private TestUserCatalog testUserCatalog;

    public TestCase(long id) {
        super(id);
        testUserCatalog = new TestUserCatalog();
    }

    public long getId() {
        return id;
    }

    public TestUserCatalog getTestUserCatalog() {
        return testUserCatalog;
    }

    public void setTestUserCatalog(TestUserCatalog testUserCatalog) {
        this.testUserCatalog = testUserCatalog;
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
