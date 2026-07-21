package com.cognizant.account.service;

import org.springframework.stereotype.Service;

import com.cognizant.account.model.Account;

@Service
public class AccountService {

    public Account getAccount() {

        return new Account(
                1001,
                "Rahul Sharma",
                "Savings",
                250000.00
        );
    }
}