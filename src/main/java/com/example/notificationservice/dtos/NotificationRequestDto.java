package com.example.notificationservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequestDto {

    private String eventType;
    private String templateBody;
}
