package com.codecademy.domain;

import java.time.LocalDateTime;

public class Certificate{

private String certificateID;
private double grade;
private String employee;
private LocalDateTime enrollmenDateTime;




public Certificate(String certificateID, double grade, String employee) {
        this.certificateID = certificateID;
        this.grade = grade;
        this.employee = employee;
    }
    
    public String getCertificateID() {
        return certificateID;
    }
    
    public double getGrade() {
        return grade;
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    public String getEmployee() {
        return employee;
    }
    
    public void setEmployee(String employee) {
        this.employee = employee;
    }
    
    public LocalDateTime getEnrollmenDateTime() {
        return enrollmenDateTime;
    }
    
    public void setEnrollmenDateTime(LocalDateTime enrollmenDateTime) {
        this.enrollmenDateTime = enrollmenDateTime;
    }
}