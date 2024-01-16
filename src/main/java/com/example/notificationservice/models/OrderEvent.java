package com.example.notificationservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEvent {

    private String orderId;
    private String userEmail;
    private String eventType;

    // Constructors, getters, setters
}

