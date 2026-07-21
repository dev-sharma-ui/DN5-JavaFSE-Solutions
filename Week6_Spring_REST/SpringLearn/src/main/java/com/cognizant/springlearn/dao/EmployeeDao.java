package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.employee.Employee;

@Repository
public class EmployeeDao {

    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Rahul", 50000));
        employees.add(new Employee(2, "Priya", 60000));
        employees.add(new Employee(3, "Amit", 70000));

        return employees;
    }
}