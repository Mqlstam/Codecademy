package com.codecademy.domain;

import java.time.LocalDate;

public abstract class Content {
    protected int contentItemId;
    protected String contentTitle, contentDesc;
    protected Status status;
    protected LocalDate publicationDate;
    
    public Content(int contentItemId, String contentDesc, LocalDate publicationDate, Status status) {
        this.contentItemId = contentItemId;
        this.contentDesc = contentDesc;
        this.publicationDate = publicationDate;
        this.status = status;
    }


    
}
