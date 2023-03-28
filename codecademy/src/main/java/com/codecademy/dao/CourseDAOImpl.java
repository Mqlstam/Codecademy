package com.codecademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codecademy.domain.Course;
import com.codecademy.domain.Difficulty;
import com.codecademy.database.DbConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CourseDAOImpl implements CourseDAO{
    private DbConnection dbConnection;

    public CourseDAOImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public ObservableList<Course> getCourses() {
                try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("SELECT * FROM Course");
            ResultSet result = query.executeQuery();

            ObservableList<Course> list = FXCollections.observableArrayList();

            while (result.next()) {
                Difficulty difficulty;
                if (result.getString("CourseDifficulty") == "Beginner" || result.getString("CourseDifficulty") == "BEGINNER") {
                    difficulty = Difficulty.BEGINNER;
                } else if (result.getString("CourseDifficulty") == "Intermediate" || result.getString("CourseDifficulty") == "INTERMEDIATE") {
                    difficulty = Difficulty.ADVANCED;
                } else {
                    difficulty = Difficulty.EXPERT;
                }
                list.add(new Course(result.getString("CourseName"), result.getInt("ModuleId"), result.getString("CourseTopic"), result.getString("CourseIntroText"), result.getString("CourseTag"), difficulty));
            }
            return list;
        } catch (SQLException e) {
            System.err.println("Error in getStudents");
            e.printStackTrace();
        }
        return null;
     }

    @Override
    public ObservableList<String> getAllCourseNames() {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("SELECT CourseName FROM Course");
            ResultSet result = query.executeQuery();
            ObservableList<String> list = FXCollections.observableArrayList();

            while (result.next()) {
                list.add(result.getString("CourseName"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error in getAllCourseNames");
            e.printStackTrace();
        }
        return null; }

    @Override
    public void addCourse(Course course) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("INSERT INTO Course VALUES(?, ?, ?, ?, ?, ?)");
            query.setString(1, course.getCourseName());
            query.setInt(2, course.getModuleId());
            query.setString(3, course.getCourseTopic());
            query.setString(4, course.getCourseIntroText());
            query.setString(5, course.getCourseTag());
            query.setString(6, course.getDifficulty().toString());
            query.executeUpdate();
            System.out.println("Course added");
        } catch (SQLException e) {
            System.out.println("Error in addCourse");
            e.printStackTrace();
        } }

    @Override
    public void updateCourse(Course course) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("DELETE FROM Course WHERE CourseName = ?");
            query.setString(1, course.getCourseName());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleteCourse");
            e.printStackTrace();
        } }

    @Override
    public void deleteCourse(Course course) {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("UPDATE Course SET ModuleId = ?, CourseTopic = ?, CourseIntroText = ?, CourseTag = ?, CourseDifficulty = ? WHERE CourseName = ?"); 
            query.setInt(1, course.getModuleId());
            query.setString(2, course.getCourseTopic());
            query.setString(3, course.getCourseIntroText());
            query.setString(4, course.getCourseTag());
            query.setString(5, course.getDifficulty().toString());
            query.setString(6, course.getCourseName());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in updateCourse");
            e.printStackTrace(); 
        } }

    
}
