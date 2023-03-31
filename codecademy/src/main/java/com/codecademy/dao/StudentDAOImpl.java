package com.codecademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codecademy.database.DbConnection;
import com.codecademy.domain.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentDAOImpl implements StudentDAO{

    private DbConnection dbConnection;

    public StudentDAOImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public ObservableList<Student> getStudents() {
        try (Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("SELECT * FROM Student");
            ResultSet result = query.executeQuery();

            ObservableList<Student> list = FXCollections.observableArrayList();

            while (result.next()) {
                list.add(new Student(result.getString("StudentEmail"), result.getString("Name"), result.getDate("BirthDate").toLocalDate(), result.getString("Gender"), result.getString("Adress"), result.getString("Country"), result.getString("City")));
            }
            return list;
        } catch (Exception e) {
            System.err.println("Error in getStudents");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ObservableList<String> getAllStudentEmails() {
        try (Connection db = dbConnection.getConnection()){
            PreparedStatement query = db.prepareStatement("SELECT StudentEmail FROM Student");
            ResultSet result = query.executeQuery();
            ObservableList<String> list = FXCollections.observableArrayList();

            while (result.next()) {
                list.add(result.getString("StudentEmail"));
            }
            return list;
        } catch (Exception e) {
            System.out.println("Error in getAllStudentEmails");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
    try (Connection db = dbConnection.getConnection()) {
        PreparedStatement query = db.prepareStatement("INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?, ?)");
        query.setString(1, student.getEmail());
        query.setString(2, student.getName());
        query.setDate(3, java.sql.Date.valueOf(student.getBirthDate()));
        query.setString(4, student.getGender());
        query.setString(5, student.getAdress());
        query.setString(6, student.getCountry());
        query.setString(7, student.getCity());
        query.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error in addStudent");
        e.printStackTrace();
    }
    }

    @Override
    public void updateStudent(Student student) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("UPDATE Student SET Name = ?, BirthDate = ?, Gender = ?, Adress = ?, Country = ?, City = ? WHERE StudentEmail = ?"); 
            query.setString(1, student.getName());
            query.setDate(2, java.sql.Date.valueOf(student.getBirthDate()));
            query.setString(3, student.getGender());
            query.setString(4, student.getAdress());
            query.setString(5, student.getCountry());
            query.setString(6, student.getCity());
            query.setString(7, student.getEmail());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in updateStudent");
            e.printStackTrace(); 
        }
    }

    @Override
    public void deleteStudent(Student student) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("DELETE FROM Student WHERE StudentEmail = ?");
            query.setString(1, student.getEmail());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleteStudent");
            e.printStackTrace();
        }
    }
    
    @Override
    public List<String> getCertificatesByEmail(String email) {
        List<String> certificates = new ArrayList<>();
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("SELECT Certificate.CertificateID FROM Certificate INNER JOIN Enrollment ON Certificate.CertificateID = Enrollment.CertificateID WHERE Enrollment.StudentEmail = ?");
            query.setString(1, email);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                String certificateName = rs.getString("CertificateID");
                certificates.add(certificateName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificates;
    }
}
