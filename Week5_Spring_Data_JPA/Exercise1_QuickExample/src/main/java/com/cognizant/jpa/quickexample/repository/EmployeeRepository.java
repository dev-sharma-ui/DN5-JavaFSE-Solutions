package com.cognizant.jpa.quickexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.jpa.quickexample.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

