package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PersonalizeTest {

    @JsonProperty("id")
    private int id;
    private List<QuestionTest> questions;
    private float grade;

    public PersonalizeTest() {
        id = -1;
        questions = new ArrayList<>();
    }

    public PersonalizeTest(int id, List<QuestionTest> questions) {
        this.id = id;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<QuestionTest> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionTest> questions) {
        this.questions = questions;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void calculateGrade() {
        if(questions == null || questions.isEmpty()) {
            this.grade = 0;
            return;
        }
        float newGrade = 0;
        for(QuestionTest question : questions) {
            newGrade += question.getGrade();
        }
        this.grade = newGrade/questions.size();
     }

    @Override
    public String toString() {
        return "PersonalizeTest{" +
                "id=" + id +
                ", questions=" + questions +
                ", grade=" + grade +
                '}';
    }
}
