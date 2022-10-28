package com.company.customer.service;

import org.springframework.stereotype.Service;

import com.company.customer.controller.Request.CustomerResgistrationRequest;
import com.company.customer.model.Customer;
import com.company.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerResgistrationRequest request) {
        Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();

        //todo: check if email valid
        //todo: check if email not token
        //todo: store customer in db
        customerRepository.save(customer);
    }

}
