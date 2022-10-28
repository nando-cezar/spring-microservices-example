package com.company.fraud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.fraud.controller.Response.FraudCehckResponse;
import com.company.fraud.service.FraudCheckService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path="{customerId}")
    public FraudCehckResponse isFraudster(@PathVariable("customerId") Integer customerID){
        boolean isFraudulentCustomer = fraudCheckService.isFraudlentCustomer(customerID);
        return new FraudCehckResponse(isFraudulentCustomer);
    }
}
