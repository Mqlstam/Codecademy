package com.codecademy.dao;

import java.util.List;

import com.codecademy.domain.Module;
import javafx.collections.ObservableList;

public interface ModuleDAO {
    public void getAverageProgressPerModule(int courseId);
    public boolean hasCompletedAllModules(String emailAddress, int courseId);
    
}