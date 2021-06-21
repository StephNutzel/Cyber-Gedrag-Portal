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
    @JsonProperty("company_name")
    private String companyName;

    private TestUserCatalog testUserCatalog;
    public float avgGradePasswordTest;
    public float avgGradePopupTest;
    public float avgGradePersonalizeTest;
    public float avgGradeTotal;

    public TestCase() {
        super(-1);
        date = new Date(0L);
        name = "";
        participantGoal = -1;
        testUserCatalog = new TestUserCatalog();
        avgGradeTotal = 0;
        companyName = "";
    }

    public TestCase(int id, Date date, String name, int participantGoal, TestUserCatalog testUserCatalog, float avgGrade, String companyName) {
        super(id);
        this.date = date;
        this.name = name;
        this.participantGoal = participantGoal;
        this.testUserCatalog = testUserCatalog;
        this.avgGradeTotal = avgGrade;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParticipantGoal() {
        return participantGoal;
    }

    public void setParticipantGoal(int participantGoal) {
        this.participantGoal = participantGoal;
    }

    public boolean isTestState() {
        return testState;
    }

    public void setTestState(boolean testState) {
        this.testState = testState;
    }

    public void calculateAvgGrade() {
        float newAvgGradePassword = 0;
        float newAvgGradePersonalizeTest = 0;
        float newAvgGradePopupTest = 0;
        int sizePassword = 0;
        int sizePopup = 0;
        int sizePersonalize = 0;
        for(TestUser testUser : testUserCatalog.findAll()) {
            if(testUser.getPasswordTest() != null) {
                float grade = testUser.getPasswordTest().getGrade();
                sizePassword++;
                if(grade > 0) {
                    newAvgGradePassword += grade;
                }
            }
            if(testUser.getPersonalizeTest() != null) {
                float grade = testUser.getPersonalizeTest().getGrade();
                sizePersonalize++;
                if(grade > 0) {
                    newAvgGradePersonalizeTest += grade;
                }
            }
            if(testUser.getPopupTest() != null) {
                float grade = testUser.getPopupTest().getGrade();
                sizePopup++;
                if(grade > 0) {
                    newAvgGradePopupTest += grade;
                }
            }
        }
        avgGradePasswordTest = newAvgGradePassword/sizePassword;
        avgGradePersonalizeTest = newAvgGradePersonalizeTest/sizePersonalize;
        avgGradePopupTest = newAvgGradePopupTest/sizePopup;
        avgGradeTotal = (avgGradePasswordTest + avgGradePersonalizeTest + avgGradePopupTest) / 3;
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
