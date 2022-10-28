package com.company.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
