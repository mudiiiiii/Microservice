package com.lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lab4.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    public Employee findByUserName(String userName);

}
