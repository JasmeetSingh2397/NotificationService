package com.example.notificationservice.services;


import com.example.notificationservice.models.NotificationTemplate;
import com.example.notificationservice.models.OrderEvent;

public class OrderConfirmationTemplates implements NotificationTemplateCreatorInterface {
    @Override
    public NotificationTemplate buildEmailBody(OrderEvent orderEvent) {
        String orderId = orderEvent.getOrderId();
        String userEmail = orderEvent.getUserEmail();

        NotificationTemplate notificationTemplate= new NotificationTemplate();


        String templateBody= "Dear Customer,\n\n"
                + "Thank you for your order!\n\n"
                + "Order Details:\n"
                + "Order ID: " + orderId + "\n"
                + "Product Name: " + "Iphone 15 Pro Max" + "\n"
                + "User Email: " + userEmail + "\n\n"
                + "We appreciate your business.\n"
                + "Best Regards,\n"
                + "Your Company Name";

        notificationTemplate.setTemplateBody(templateBody);
        notificationTemplate.setEventType("orderConfirmation");
        return notificationTemplate;
    }
}
