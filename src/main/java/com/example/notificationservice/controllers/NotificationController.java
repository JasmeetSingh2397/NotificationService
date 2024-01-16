package com.example.notificationservice.controllers;


import com.example.notificationservice.dtos.NotificationRequestDto;
import com.example.notificationservice.services.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private NotificationService notificationService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveNotificationTemplate(@RequestBody NotificationRequestDto request){
        notificationService.saveTemplate(request.getEventType(), request.getTemplateBody());
        return new ResponseEntity<>(HttpStatus.OK);


    }
}
