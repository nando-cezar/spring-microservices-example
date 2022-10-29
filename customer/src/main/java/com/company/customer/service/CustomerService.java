package com.company.customer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.customer.controller.Request.CustomerResgistrationRequest;
import com.company.customer.controller.Response.FraudCheckResponse;
import com.company.customer.model.Customer;
import com.company.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository; 
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerResgistrationRequest request) {
        Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();

        //todo: check if email valid
        //todo: check if email not token
        customerRepository.saveAndFlush(customer);
        //todo: check if fraudster
        FraudCheckResponse  fraudCheckResponse = restTemplate.getForObject(
            "http://FRAUD/api/v1/fraud-check/{customerId}", 
            FraudCheckResponse.class,
            customer.getId()
        );
        
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        //todo: send notification
    }

}
