package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.employee.Employee;

@Repository
public class EmployeeDao {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeDao() {
        employees.add(new Employee(1, "Rahul", 50000));
        employees.add(new Employee(2, "Priya", 60000));
        employees.add(new Employee(3, "Amit", 70000));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(int id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, employee);
                return employee;
            }
        }
        return null;
    }

    public void deleteEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }
}