package com.example.notificationservice.services;


import com.example.notificationservice.models.NotificationTemplate;
import com.example.notificationservice.models.OrderEvent;

public interface NotificationTemplateCreatorInterface {
    NotificationTemplate buildEmailBody(OrderEvent orderEvent);
}