package com.company.fraud.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.company.fraud.model.FraudCheckHistory;
import com.company.fraud.repository.FraudCheckHistoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {
    
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudlentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
            FraudCheckHistory.builder()
            .customerId(customerId)
            .isFraudster(false)
            .createdAt(LocalDateTime.now())
            .build());
        return false;
    }
}
