package com.cognizant.jpa.quickexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.jpa.quickexample.entity.Employee;
import com.cognizant.jpa.quickexample.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public void saveEmployee() {

        Employee employee = new Employee(
                "Rahul",
                "IT");

        repository.save(employee);

        System.out.println("Employee Saved Successfully");
    }
}