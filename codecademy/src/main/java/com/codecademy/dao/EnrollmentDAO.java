package com.codecademy.dao;

import com.codecademy.domain.Enrollment;
import javafx.collections.ObservableList;


public interface EnrollmentDAO {
    ObservableList<Enrollment> getEnrollments();
    void addEnrollment(String studentEmail, String courseName);
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(Enrollment enrollment);
}