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

    public List<Integer> getModuleProgress(String studentEmail, String courseName) {

        return null;
    }
    
}
