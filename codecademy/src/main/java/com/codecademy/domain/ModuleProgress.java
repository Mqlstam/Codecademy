package com.codecademy.domain;

public class ModuleProgress {
    private int followNumber;
    private String moduleName;
    private double averageProgress;

    public ModuleProgress(int followNumber, String moduleName, double averageProgress) {
        this.followNumber = followNumber;
        this.moduleName = moduleName;
        this.averageProgress = averageProgress;
    }

    public int getFollowNumber() {
        return followNumber;
    }

    public String getModuleName() {
        return moduleName;
    }

    public double getAverageProgress() {
        return averageProgress;
    }
}
