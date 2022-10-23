package com.company.customer.controller.Request;

public record CustomerResgistrationRequest(
    Integer id,
    String firstName,
    String lastName,
    String email
){}
