package com.cognizant.springlearn.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.employee.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {
        return employeeDao.updateEmployee(id, employee);
    }

    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}