package com.codecademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codecademy.database.DbConnection;

public class WebcastDAOimpl implements WebcastDAO{

    private DbConnection dbConnection;

    @Override
    public List<String> getTop3ViewedWebcasts() {
        List<String> top3Webcasts = new ArrayList<>();

        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement(
                    "SELECT TOP 3 w.WebcastTitle, COUNT(*) as Views " +
                    "FROM Student_Content sc " +
                    "JOIN Webcast w ON sc.ContentID = w.ContentID " +
                    "GROUP BY w.WebcastTitle" +
                    "ORDER BY Views DESC");
    
            ResultSet rs = query.executeQuery();
    
            while (rs.next()) {
                String webcastTitle = rs.getString("Title");
                int views = rs.getInt("Views");
                top3Webcasts.add(webcastTitle + " (" + views + " views)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return top3Webcasts;
    }
    
}
