package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PopupTest {
    @JsonProperty("id")
    private int id;
    @JsonProperty("clicked")
    private boolean hasClicked;

    private float grade;

    public PopupTest() {
        this.id = -1;
        this.hasClicked = false;
    }

    public PopupTest(int id, boolean hasClicked) {
        this.id = id;
        this.hasClicked = hasClicked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHasClicked() {
        return hasClicked;
    }

    public void setHasClicked(boolean hasClicked) {
        this.hasClicked = hasClicked;
    }

    public void calculateGrade() {
        if(this.hasClicked) {
            this.grade = 10;
        }
        this.grade = 0;
    }

    @Override
    public String toString() {
        return "PopupTest{" +
                "id=" + id +
                ", hasClicked=" + hasClicked +
                ", grade=" + grade +
                '}';
    }
}
