package com.codecademy.domain;

import java.time.LocalDate;

public class Content {
    protected int contentItemId;
    protected String contentTitle, contentDesc;
    protected LocalDate publicationDate;
    
    public Content(int contentItemId, String contentDesc, LocalDate publicationDate) {
        this.contentItemId = contentItemId;
        this.contentDesc = contentDesc;
        this.publicationDate = publicationDate;
    }
    
}
