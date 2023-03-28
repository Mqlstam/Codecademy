package com.codecademy.dao;

import com.codecademy.domain.Student;
import javafx.collections.ObservableList;

public interface StudentDAO {
    ObservableList<Student> getStudents();
    ObservableList<String> getAllStudentEmails();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}