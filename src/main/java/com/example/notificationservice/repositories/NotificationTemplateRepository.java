package com.example.notificationservice.repositories;


import com.example.notificationservice.models.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate,Long> {

}
