package com.example.prac02;

public class Staff {
    private String staffId;
    private String staffFullName;
    private String birthDate;
    private String salary;

    public Staff(String staffId, String staffFullName, String birthDate, String salary) {
        this.staffId = staffId;
        this.staffFullName = staffFullName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffFullName() {
        return staffFullName;
    }

    public void setStaffFullName(String staffFullName) {
        this.staffFullName = staffFullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return staffId+"-"+staffFullName+"-"+birthDate+"-"+salary;
    }
}
