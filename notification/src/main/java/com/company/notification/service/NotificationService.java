package com.company.notification.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.company.clients.notification.NotificationRequest;
import com.company.notification.model.Notification;
import com.company.notification.repository.NotificationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {
    
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(
            Notification.builder()
            .toCustomerId(notificationRequest.toCustomerId())
            .toCustomerEmail(notificationRequest.toCustomerEmail())
            .sender("Company")
            .message(notificationRequest.message())
            .sentAt(LocalDateTime.now())
            .build()
        );
    }
}
