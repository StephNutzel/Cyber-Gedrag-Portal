package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mozilla.javascript.annotations.JSConstructor;

public class QuestionTest {

    @JsonProperty("answered")
    private boolean hasAnswered;
    @JsonProperty("question")
    private String questionStr;
    private float grade;

    public QuestionTest() {
        hasAnswered = false;
        questionStr = "";
        calculateGrade();
    }

    public QuestionTest(boolean hasAnswered, String questionStr) {
        this.hasAnswered = hasAnswered;
        this.questionStr = questionStr;
        calculateGrade();
    }

    public boolean isHasAnswered() {
        return hasAnswered;
    }

    public void setHasAnswered(boolean hasAnswered) {
        this.hasAnswered = hasAnswered;
        calculateGrade();
    }

    public String getQuestionStr() {
        return questionStr;
    }

    public void setQuestionStr(String questionStr) {
        this.questionStr = questionStr;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void calculateGrade() {
        if(this.hasAnswered) {
            this.grade = 10;
        }
        this.grade = 0;
    }

    @Override
    public String toString() {
        return "QuestionTest{" +
                "hasAnswered=" + hasAnswered +
                ", questionStr='" + questionStr + '\'' +
                ", grade=" + grade +
                '}';
    }
}
