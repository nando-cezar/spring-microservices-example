package com.company.customer.controller.request;

public record CustomerResgistrationRequest(
    Integer id,
    String firstName,
    String lastName,
    String email
){}
