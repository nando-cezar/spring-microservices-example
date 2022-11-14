package com.company.customer.service;

import org.springframework.stereotype.Service;

import com.company.clients.fraud.FraudCheckResponse;
import com.company.clients.fraud.FraudClient;
import com.company.clients.notification.NotificationClient;
import com.company.clients.notification.NotificationRequest;
import com.company.customer.controller.request.CustomerResgistrationRequest;
import com.company.customer.model.Customer;
import com.company.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository; 
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerResgistrationRequest request) {
        Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();

        //todo: check if email valid
        //todo: check if email not token
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        
        //todo: make it async. i.e add to queue
        notificationClient.sendNotification(
            new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Company...", customer.getFirstName())
            )
        );
    }

}
