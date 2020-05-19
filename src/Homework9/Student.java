package Homework9;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String name;
    private char gender;
    private String birthDay;
    private int groupNumber;

    public Student(String name, char gender, String birthDay, int groupNumber) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return gender == student.gender &&
                groupNumber == student.groupNumber &&
                Objects.equals(name, student.name) &&
                Objects.equals(birthDay, student.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthDay, groupNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name + ", gender=" + gender +
                ", birthDay=" + birthDay +
                ", groupNumber=" + groupNumber + '}';
    }

}
