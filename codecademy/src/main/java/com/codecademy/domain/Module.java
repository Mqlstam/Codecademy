package com.codecademy.domain;

public class Module {
    private int followNumber; // primary key
    private int contentID;
    private String moduleTitle;
    private int version;
    private double progress;
    private String contactPersonEmail;
    private String courseName;

    // Constructor
    public Module(int followNumber, String moduleTitle, int contentID, int version, String courseName, String contactPersonEmail) {
        this.followNumber = followNumber;
        this.contentID = contentID;
        this.moduleTitle = moduleTitle;
        this.version = version;
        this.contactPersonEmail = contactPersonEmail;
        this.courseName = courseName;
    }

    public Module(int followNumber, String moduleTitle, double progress) {
        this.followNumber = followNumber;
        this.moduleTitle = moduleTitle;
        this.progress = progress;
    }

    // Getters and setters
    public int getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(int followNumber) {
        this.followNumber = followNumber;
    }

    public int getContent() {
        return contentID;
    }

    public void setContent(int content) {
        this.contentID = content;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getProgress(){
        return progress;
    }

    public void setProgress(double progress){
        this.progress = progress;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

