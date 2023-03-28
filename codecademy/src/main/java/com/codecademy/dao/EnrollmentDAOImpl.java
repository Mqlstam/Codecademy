package com.codecademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codecademy.domain.Enrollment;
import com.codecademy.database.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EnrollmentDAOImpl implements EnrollmentDAO{
    private DbConnection dbConnection;

    public EnrollmentDAOImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void addEnrollment(String studentEmail, String courseName) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("INSERT INTO Enrollment VALUES(GETDATE() ,?, ?, 0)");
            query.setString(1, studentEmail);
            query.setString(2, courseName);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in addEnrollment");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEnrollment(Enrollment enrollment) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("DELETE FROM Enrollment WHERE EnrollmentDateTime = ?");
            query.setString(1, enrollment.getEnrollmentDateTime().toString());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleteEnrollment");
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Enrollment> getEnrollments() {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("SELECT * FROM Enrollment");
            ResultSet result = query.executeQuery();

            ObservableList<Enrollment> list = FXCollections.observableArrayList();

            while (result.next()) {                
                list.add(new Enrollment(result.getString("StudentEmail"), result.getString("CourseName"), result.getTimestamp("EnrollmentDateTime").toLocalDateTime()));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error in getEnrollments");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("UPDATE Enrollment SET StudentEmail = ?, CourseName = ? WHERE EnrollmentDateTime = ?");
            query.setString(1, enrollment.getStudentEmail());
            query.setString(2, enrollment.getCourseName());
            query.setString(3, enrollment.getEnrollmentDateTime().toString());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in updateEnrollment");
            e.printStackTrace();
        }
        
    }
    
    
}
