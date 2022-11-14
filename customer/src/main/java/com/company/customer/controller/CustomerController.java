package com.company.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.customer.controller.request.CustomerResgistrationRequest;
import com.company.customer.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    
    @PostMapping
    public void registerCustomer(@RequestBody CustomerResgistrationRequest customerResgistrationRequest) {
        log.info("new customer registration {}", customerResgistrationRequest);
        customerService.registerCustomer(customerResgistrationRequest);
    }
}
