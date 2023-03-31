package com.codecademy.dao;

import java.util.List;

import com.codecademy.domain.Module;
import javafx.collections.ObservableList;

public interface ModuleDAO {
    public List<Integer> getModuleProgress(String studentEmail, String courseName);
}