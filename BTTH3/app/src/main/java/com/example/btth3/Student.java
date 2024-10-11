package com.example.btth3;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String id,gender,birth_date,email,address,major;
    private float gpa;
    private int year;
    Full_name full_name;

    public Student(String id, String gender, String birth_date, String email, String address, String major, float gpa, int year, Full_name full_name) {
        this.id = id;
        this.gender = gender;
        this.birth_date = birth_date;
        this.email = email;
        this.address = address;
        this.major = major;
        this.gpa = gpa;
        this.year = year;
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Full_name getFull_name() {
        return full_name;
    }
    public String getFistName(){
        return this.getFull_name().getFirst();
    }
    public String getLastName(){
        return this.getFull_name().getLast();
    }
    public void setFull_name(Full_name full_name) {
        this.full_name = full_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Float.compare(gpa, student.gpa) == 0 && year == student.year && Objects.equals(id, student.id) && Objects.equals(gender, student.gender) && Objects.equals(birth_date, student.birth_date) && Objects.equals(email, student.email) && Objects.equals(address, student.address) && Objects.equals(major, student.major) && Objects.equals(full_name, student.full_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, birth_date, email, address, major, gpa, year, full_name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                ", year=" + year +
                ", full_name=" + full_name +
                '}';
    }
}