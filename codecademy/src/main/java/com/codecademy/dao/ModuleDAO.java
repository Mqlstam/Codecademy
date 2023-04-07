package com.codecademy.dao;

import java.util.List;

import com.codecademy.domain.Module;
import com.codecademy.domain.ModuleProgress;

import javafx.collections.ObservableList;

public interface ModuleDAO {
    ObservableList<Module> getAllModules();
    public List<Module> getAverageProgressPerModule(String courseName, String studentEmail);
    public List<ModuleProgress> getAverageProgressPerModuleAllStudents(String courseName);
}