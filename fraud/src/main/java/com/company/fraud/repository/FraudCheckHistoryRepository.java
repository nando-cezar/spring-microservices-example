package com.company.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.fraud.model.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer>{
    
}
