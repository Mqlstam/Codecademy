package com.codecademy.domain;

public class Module {
    private int moduleVersion, followNumber;
    private String contactName, contactEmail;

    public Module(int moduleVersion, int followNumber, String contactName, String contactEmail) {
        this.moduleVersion = moduleVersion;
        this.followNumber = followNumber;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    
}
