package com.codecademy.domain;

public class ModuleProgress {
    private String moduleName;
    private double averageProgress;

    public ModuleProgress(String moduleName, double averageProgress) {
        this.moduleName = moduleName;
        this.averageProgress = averageProgress;
    }

    public String getModuleName() {
        return moduleName;
    }

    public double getAverageProgress() {
        return averageProgress;
    }
}
