package com.cognizant.springlearn.service;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;

@Service
public class CountryService {

    public Country getCountry() {
        return new Country("IN", "India");
    }
}