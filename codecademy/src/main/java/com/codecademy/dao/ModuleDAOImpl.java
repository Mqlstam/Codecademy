package com.codecademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codecademy.database.DbConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModuleDAOImpl implements ModuleDAO {
  
    private DbConnection dbConnection;

    @Override
public void getAverageProgressPerModule(int courseId) {
    try (Connection db = dbConnection.getConnection()) {
    
        // Get the average progress per module for the selected course
        String averageProgressQuery = "SELECT M.FollowNumber, M.ModuleTitle, AVG(SC.PercentageViewed) AS average_progress " +
            "FROM Module M " +
            "JOIN Content C ON M.ContentID = C.ContentID " +
            "JOIN Student_Content SC ON C.ContentID = SC.ContentItemID " +
            "WHERE C.ContentID IN (SELECT ContentItemID FROM Course WHERE CourseID = ?) " +
            "GROUP BY M.FollowNumber, M.ModuleTitle " +
            "ORDER BY M.FollowNumber;";

        PreparedStatement averageProgressStatement = db.prepareStatement(averageProgressQuery);
        averageProgressStatement.setInt(1, courseId);

        ResultSet resultSet = averageProgressStatement.executeQuery();

        System.out.println("Average progress per module for course ID " + courseId + ":");
        while (resultSet.next()) {
            int moduleId = resultSet.getInt("FollowNumber");
            String title = resultSet.getString("ModuleTitle");
            double averageProgress = resultSet.getDouble("average_progress");

            System.out.println("Module ID: " + moduleId + ", Title: " + title + ", Average progress: " + averageProgress + "%");
        }
    } catch (SQLException e) {
        System.out.println("Error while getting the average progress per module: " + e.getMessage());
    }
}

    
}
