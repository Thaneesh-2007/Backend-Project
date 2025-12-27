package com.examly.springapp.service;

import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    
    @Autowired
    private PaymentRepo paymentRepo;
    
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }
}