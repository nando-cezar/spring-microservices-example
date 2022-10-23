package com.company.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.customer.controller.Request.CustomerResgistrationRequest;
import com.company.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerResgistrationRequest customerResgistrationRequest) {
        log.info("new customer registration {}", customerResgistrationRequest);
        customerService.registerCustomer(customerResgistrationRequest);
    }
}
