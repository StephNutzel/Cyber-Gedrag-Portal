package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Tester {

    @JsonProperty("id")
    private int id;
    private String name;
    private String email;
    private TestCaseCatalog testCaseCatalog;
    private TestCase activeTestCase;
    @JsonProperty("access_token")
    private String token;

    public Tester() {
        token = null;
        name = null;
        email = null;
        testCaseCatalog = new TestCaseCatalog();
        activeTestCase = null;
    }

    public Tester(int id, String name, String email) {
        token = null;
        this.id = id;
        this.name = name;
        this.email = email;
        testCaseCatalog = new TestCaseCatalog();
        activeTestCase = null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TestCaseCatalog getTestCaseCatalog() {
        return testCaseCatalog;
    }

    public void setTestCaseCatalog(TestCaseCatalog testCaseCatalog) {
        this.testCaseCatalog = testCaseCatalog;
    }

    public TestCase getActiveTestCase() {
        return activeTestCase;
    }

    public void setActiveTestCase(TestCase testCase) {
        this.activeTestCase = testCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tester tester = (Tester) o;
        return id == tester.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", testCaseCatalog=" + testCaseCatalog +
                ", activeTestCase=" + activeTestCase +
                ", token='" + token + '\'' +
                '}';
    }
}
