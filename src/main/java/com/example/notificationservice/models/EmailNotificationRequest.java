package com.example.notificationservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailNotificationRequest {

    private String to;
    private String subject;
    private String body;

    // Constructors, getters, setters
}

