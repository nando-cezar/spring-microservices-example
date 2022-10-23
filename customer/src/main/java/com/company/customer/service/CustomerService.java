package com.company.customer.service;

import org.springframework.stereotype.Service;

import com.company.customer.controller.Request.CustomerResgistrationRequest;
import com.company.customer.model.Customer;

@Service
public record CustomerService(){

    public void registerCustomer(CustomerResgistrationRequest request) {
        Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();

        //todo: check if email valid
        //todo: check if email not token
        //todo: store customer in db
    }

}
