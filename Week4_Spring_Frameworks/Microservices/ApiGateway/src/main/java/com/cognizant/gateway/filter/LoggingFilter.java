package com.cognizant.gateway.filter;

import org.springframework.stereotype.Component;

@Component
public class LoggingFilter {

    public LoggingFilter() {
        System.out.println("Global Logging Filter Initialized");
    }

}