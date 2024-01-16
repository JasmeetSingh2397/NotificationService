package com.example.notificationservice.services;


import com.example.notificationservice.models.EmailNotificationRequest;
import com.example.notificationservice.models.NotificationTemplate;
import com.example.notificationservice.models.OrderEvent;
import com.example.notificationservice.repositories.NotificationTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private NotificationTemplateRepository templateRepository; // Assuming you have a repository


    @KafkaListener(topics = "successful-orders", groupId = "notification-group")
    public void handleSuccessfulOrder(OrderEvent event) {
        OrderConfirmationTemplates orderConfirmationTemplate= new OrderConfirmationTemplates();
        NotificationTemplate template = orderConfirmationTemplate.buildEmailBody(event);
        EmailNotificationRequest notificationRequest = buildEmailNotification(event, template);
        sendEmailNotification(notificationRequest);

    }

    private EmailNotificationRequest buildEmailNotification(OrderEvent orderEvent, NotificationTemplate template) {
        // Extract necessary information from orderEvent
        String orderId = orderEvent.getOrderId();
        String userEmail = orderEvent.getUserEmail();

        // Build email content using the template
        String emailBody = template.getTemplateBody();

        // Create and return email request
        EmailNotificationRequest request = new EmailNotificationRequest();
        request.setTo(userEmail);
        request.setSubject("Order Confirmation - Order ID: " + orderId);
        request.setBody(emailBody);

        return request;
    }

    public void sendEmailNotification(EmailNotificationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getBody());

        javaMailSender.send(message);
    }

    public void saveTemplate(String eventType, String templateBody) {
        NotificationTemplate templateEntity = new NotificationTemplate();
        templateEntity.setEventType(eventType);
        templateEntity.setTemplateBody(templateBody);

        templateRepository.save(templateEntity);
    }
}

