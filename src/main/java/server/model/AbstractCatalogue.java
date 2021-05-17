package server.model;

import server.model.PasswordTest;

import java.util.HashMap;
import java.util.List;

public abstract class AbstractCatalogue {

    private int size;
    private float avgGrade;

    public AbstractCatalogue() {
        size = 0;
        avgGrade = 0;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public float getSize() {
        return this.size;
    }

    public float addAvgGrade(float grade) {
        this.avgGrade = (avgGrade * size + grade)/++size;
        return this.avgGrade;
    }

    public float subtractAvgGrade(float grade) {
        this.avgGrade = (avgGrade * size - grade)/--size;
        return this.avgGrade;
    }



}
