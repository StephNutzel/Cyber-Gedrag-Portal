package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.HashMap;
import java.util.Objects;

public class TestCase extends AbstractModel {

    @JsonProperty("created_on")
    private Date date;
    @JsonProperty("test_case_name")
    private String name;
    @JsonProperty("participant_goal")
    private int participantGoal;
    @JsonProperty("test_state")
    private boolean testState;

    private TestUserCatalog testUserCatalog;
    private float avgGradePasswordTest;
    private float avgGradePopupTest;
    private float avgGradePersonalizeTest;
    private float avgGradeTotal;

    public TestCase() {
        super(-1);
        date = new Date(0L);
        name = "";
        participantGoal = -1;
        testUserCatalog = new TestUserCatalog();
    }

    public TestCase(int id, Date date, String name, int participantGoal, TestUserCatalog testUserCatalog, float avgGrade) {
        super(id);
        this.date = date;
        this.name = name;
        this.participantGoal = participantGoal;
        this.testUserCatalog = testUserCatalog;
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

    public void calculateAvgGrade() {
        float newAvgGradePassword = 0;
        float newAvgGradePersonalizeTest = 0;
        float newAvgGradePopupTest = 0;
        float newAvgGradeTotal = 0;
        int sizePassword = 0;
        int sizePopup = 0;
        int sizePersonalize = 0;
        int sizeTotal = 0;
        for(TestUser testUser : testUserCatalog.findAll()) {
            float grade = testUser.getPasswordTest().getGrade();
            if(grade > 0) {
                sizePassword++;
                newAvgGradePassword += grade;
            }
            grade = testUser.getPersonalizeTest().getGrade();
            if(grade > 0) {
                sizePersonalize++;
                newAvgGradePersonalizeTest += grade;
            }
            grade = testUser.getPopupTest().getGrade();
            if(grade > 0) {
                sizePopup++;
                newAvgGradePopupTest += grade;
            }
        }
        avgGradePasswordTest = newAvgGradePassword/sizePassword;
        avgGradePersonalizeTest = newAvgGradePersonalizeTest/sizePersonalize;
        avgGradePopupTest = newAvgGradePopupTest/sizePopup;
        avgGradeTotal = newAvgGradeTotal/sizeTotal;
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
