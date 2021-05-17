package server.model;

import java.util.Objects;

public class PasswordTest {

    private long id;
    private int length;
    private int numNumbers;
    private int numLetters;
    private int numSpecialChar;
    private int numUppercase;
    private int numUnique;
    private float entropy;

    public PasswordTest(long id) {
        this.id = id;
    }

    public PasswordTest(long id, int length, int numNumbers, int numLetters, int numSpecialChar, int numUppercase, int numUnique, float entropy) {
        this.id = id;
        this.length = length;
        this.numNumbers = numNumbers;
        this.numLetters = numLetters;
        this.numSpecialChar = numSpecialChar;
        this.numUppercase = numUppercase;
        this.numUnique = numUnique;
        this.entropy = entropy;
    }

    public long getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumNumbers() {
        return numNumbers;
    }

    public void setNumNumbers(int numNumbers) {
        this.numNumbers = numNumbers;
    }

    public int getNumLetters() {
        return numLetters;
    }

    public void setNumLetters(int numLetters) {
        this.numLetters = numLetters;
    }

    public int getNumSpecialChar() {
        return numSpecialChar;
    }

    public void setNumSpecialChar(int numSpecialChar) {
        this.numSpecialChar = numSpecialChar;
    }

    public int getNumUppercase() {
        return numUppercase;
    }

    public void setNumUppercase(int numUppercase) {
        this.numUppercase = numUppercase;
    }

    public int getNumUnique() {
        return numUnique;
    }

    public void setNumUnique(int numUnique) {
        this.numUnique = numUnique;
    }

    public float getEntropy() {
        return entropy;
    }

    public void setEntropy(float entropy) {
        this.entropy = entropy;
    }

    public float getGrade() {
        return (float)Math.random() * 10F;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordTest that = (PasswordTest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
