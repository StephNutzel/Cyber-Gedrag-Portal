package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PasswordTest {

    @JsonProperty("id")
    private long id;
    @JsonProperty("password_length")
    private int length;
    @JsonProperty("sum_numbers")
    private int numNumbers;
    @JsonProperty("sum_letters")
    private int numLetters;
    @JsonProperty("sum_special_char")
    private int numSpecialChar;
    private int numUppercase;
    private int numUnique;
    @JsonProperty("entropy")
    private float entropy;

    public PasswordTest() {
        this.id = -1;
        this.length = -1;
        this.numNumbers = -1;
        this.numLetters = -1;
        this.numSpecialChar = -1;
        this.numUppercase = -1;
        this.numUnique = -1;
        this.entropy = -1;
    }

    public PasswordTest(int id, int length, int numNumbers, int numLetters, int numSpecialChar, int numUppercase, int numUnique, float entropy) {
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

    @Override
    public String toString() {
        return "PasswordTest{" +
                "id=" + id +
                ", length=" + length +
                ", numNumbers=" + numNumbers +
                ", numLetters=" + numLetters +
                ", numSpecialChar=" + numSpecialChar +
                ", numUppercase=" + numUppercase +
                ", numUnique=" + numUnique +
                ", entropy=" + entropy +
                '}';
    }
}
