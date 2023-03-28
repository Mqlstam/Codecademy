package com.codecademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codecademy.database.DbConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModuleDAOImpl implements ModuleDAO {
    private DbConnection dbConnection;

    public ModuleDAOImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    public ModuleDAOImpl() {
    }


    @Override
    public ObservableList<String> getModuleIds() {
        try(Connection db = dbConnection.getConnection()) {
            PreparedStatement query = db.prepareStatement("SELECT ModuleId FROM Module");
            ResultSet result = query.executeQuery();

            ObservableList<String> list = FXCollections.observableArrayList();

            while (result.next()) {
                list.add(result.getString("ModuleId"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error in getModuleIds");
            e.printStackTrace();
        }
        return null;
    }
    
}
