package com.cognizant.loan.service;

import org.springframework.stereotype.Service;

import com.cognizant.loan.model.Loan;

@Service
public class LoanService {

    public Loan getLoan() {
        return new Loan(
                5001,
                "Home Loan",
                2500000.00
        );
    }
}