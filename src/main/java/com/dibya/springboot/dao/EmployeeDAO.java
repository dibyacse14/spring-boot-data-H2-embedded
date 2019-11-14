package com.dibya.springboot.dao;

import com.dibya.springboot.model.Employee;
import com.dibya.springboot.service.EmployeeService;
import com.dibya.springboot.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmployeeDAO {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    Test test;
    public Employee insertEmployee(Employee employee) throws InterruptedException {
        Employee savedEmployee = employeeService.save(employee);
        System.out.println("Current time 1 :"+new Date(System.currentTimeMillis()));
        test.runWaitTimer();
        System.out.println("Current time 2 : "+new Date(System.currentTimeMillis()));
        return savedEmployee;
    }
}
